package JavaFeatures.MultiThreading;

/** HOW TO MAKE THREADS.
 * In Java, we can make threads by extending Thread Class OR by implementing Runnable Interface.
 * */

// By Extending Thread class.
class Demo extends Thread{
    @Override
    public void run(){   // run() of Thread class is used to run all the instructions when we invoke Start() method.
        System.out.println("Inside run() of Demo Thread (extending Thread Class)");
    }
}

// By Implementing Runnable Interface
class Demo1 implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside run() of Demo1 Thread (Implement Runnable Interface)");
    }
}
public class ThreadDemo {
    public static void main(String[] args){
        // Creating instance and calling start() of Demo Thread.
        Demo d = new Demo();
        d.start();  // Start method will start the execution of thread's run method.

        // Creating Instance of Demo1 Thread.
        Demo1 d1 = new Demo1();
        // now we need to pass runnable class's instance to thread class.
        Thread threadObj = new Thread(d1); // This step is extra if we are creating threads by implementing Runnable interface.
        threadObj.start();
    }
}
