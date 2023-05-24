package JavaFeatures.MultiThreading;

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Inside MyThread");
    }
}
public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Main thread starts");
        MyThread t = new MyThread();            // MyThread extends Thread
        t.start();
        System.out.println(t.isAlive());        // true
        t.join();                               // main method waits for thread t to complete
        System.out.println(t.isAlive());        // false
        Thread.sleep(3000);                     // main method sleeps for 3 seconds
        System.out.println("Main thread ends");
    }

}
