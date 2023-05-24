package JavaFeatures.MultiThreading;


/**
 * Here, we see the solution of synchronization problem.
 * <p>
 * exp: we used 'synchronization' keyword of registerOfCourse(), this keyword will allow only 1 thread to access common memory area at a time.
 */

class Courses {
    String courseName;
    int numOfSeats;

    public Courses(String courseName, int numOfSeats) {
        this.courseName = courseName;
        this.numOfSeats = numOfSeats;
    }

    public synchronized void registerForCourse(int rollNo) {
        try {
            if (this.numOfSeats - 1 < 0) {
                throw new Exception("No more seats available for this course");
            }
            System.out.println("Booking successful!");
            this.numOfSeats -= 1;
            System.out.println("Available seats: " + this.numOfSeats);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class RegisterThread1 extends Thread {
    Courses c;
    RegisterThread1(Courses c) {
        this.c = c;
    }
    public void run() {
        c.registerForCourse(1);
    }
}

public class SynchronizationSolu {
    public static void main(String[] args) {
        Courses cse = new Courses("CSE", 1);
        RegisterThread1 regObj1 = new RegisterThread1(cse);
        regObj1.start();
        RegisterThread1 regObj2 = new RegisterThread1(cse);
        regObj2.start();
    }
}
