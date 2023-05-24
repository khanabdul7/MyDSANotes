package JavaFeatures.MultiThreading;

/**
 * Priorities can be set from 0(lowest) to 10(highest).
 * NOTE: Thread having the highest priority doesn't guarantee to run 1st, it will run prior to all other when it will get CPU time.
 * */
class PriorityThread1 extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(2000);  // Sleep will suspend the execution of current Thread for given time.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inside run of Thread1");
    }
}
class PriorityThread2 extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inside run of Thread2");
    }
}
class PriorityThread3 extends Thread{
    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inside run of Thread3");
    }
}
public class Priorities {
    public static void main(String[] args) throws InterruptedException {
        // Creating Instances.
        PriorityThread1 p1 = new PriorityThread1();
        PriorityThread2 p2 = new PriorityThread2();
        PriorityThread3 p3 = new PriorityThread3();

        // Setting Priorities.
        p1.setPriority(8);
        p2.setPriority(5);
        p3.setPriority(7);

        p1.start();
        p2.start();
        p3.start();

    }
}
