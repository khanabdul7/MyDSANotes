package JavaFeatures.MultiThreading;

/** InterThread Communication.
 * Suppose, a Thread need to access an obj but another Thread is already have a lock(working) on same obj.
 * Here, wait() will release the lock on the obj for temporary basis until another Thread notify() to resume.
 * */
class CourseClass {
    String courseName;
    int numOfSeats;

    public CourseClass(String courseName, int numOfSeats) {
        this.courseName = courseName;
        this.numOfSeats = numOfSeats;
    }

    public synchronized void registerForCourse(int rollNo) {
        try {
            if (this.numOfSeats - 1 < 0) {
                this.wait(5000); // This releases the lock on the object and waits for 5 seconds.
                if(this.numOfSeats - 1 < 0) // Check if any seat got released by the Cancellation
                    throw new Exception("No more seats available for this course");
            }
            System.out.println("Booking successful!");
            this.numOfSeats -= 1;
            System.out.println("Available seats: " + this.numOfSeats);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public synchronized void cancelSeats() {
        try {
            this.numOfSeats += 1;
            System.out.println("Cancellation successful!");
            System.out.println("Available seats: " + this.numOfSeats);
            this.notify();    // Notifies one of the waiting threads to resume
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

class RegisterThreadClass extends Thread {
    CourseClass c;
    RegisterThreadClass(CourseClass c) {
        this.c = c;
    }
    public void run() {
        c.registerForCourse(1);
    }
}

class CancelRegistration extends Thread {
    CourseClass c;

    CancelRegistration(CourseClass c) {
        this.c = c;
    }
    public void run() {
        c.cancelSeats();
    }
}

public class InterThreadComm {
    public static void main(String args[]) throws InterruptedException {
        CourseClass cse = new CourseClass("CSE", 1);
        RegisterThreadClass regObj1 = new RegisterThreadClass(cse);
        regObj1.start();
        RegisterThreadClass regObj2 = new RegisterThreadClass(cse);
        regObj2.start();

        Thread.sleep(2000);
        // Running a cancellation thread after 2 seconds
        CancelRegistration cancelObj1 = new CancelRegistration(cse);
        cancelObj1.start();
    }
}
