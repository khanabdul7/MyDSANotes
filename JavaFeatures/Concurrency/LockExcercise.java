package JavaFeatures.Concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Exercise Description:
 *
 * Change the code of 'Callable and Future - Exercise' so that the Task class uses a Lock instance of the type “ReentrantLock”.
 *
 * Modify the Task class to have a static variable counter which is incremented by the incrementCtr() method.
 *
 * Modify the code of incrementCtr() in such a way that a lock is acquired before incrementing the counter variable and once done, the lock is released.
 *
 * In the main method, create a single instance of the task class. Submit the task instance 10 times for execution to the executor (FixedThreadPool of size 5) and get their result values in the Future<Integer> objects and print the same.
 *
 * Observe the outcome with and without a lock.
 *
 * */

class TaskThreads implements Callable<Integer> {
    private static int counter;
    private ReentrantLock lock;

    public TaskThreads(int counter, ReentrantLock lock){
        TaskThreads.counter = counter;
        this.lock = lock;
    }

    private int incrementCtr(){
        //lock.lock(); // Acquiring lock on method
        counter++;
        //lock.unlock(); // Releasing lock
        return counter;
    }
    @Override
    public Integer call() throws InterruptedException {
        incrementCtr();
        System.out.println(Thread.currentThread().getName()+" Start ");
        Thread.sleep(3000);
        System.out.println("Counter: "+counter);
        System.out.println(Thread.currentThread().getName()+" End ");
        return counter;
    }
}

public class LockExcercise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ReentrantLock lock = new ReentrantLock(); // creating lock instance.

        TaskThreads task = new TaskThreads(0,lock); // Creating instance of TaskThread class.

        // Creating FixedSizeThreadPool of 5 Threads
        ExecutorService exServicePool = Executors.newFixedThreadPool(5);


        int noOfUploadTasks = 10;

        for (int i=1; i<=noOfUploadTasks; i++){
            // Executing using submit() and storing in Future Objects
            Future<Integer> future = (Future<Integer>) exServicePool.submit(task);

            // Getting value form Future obj
            System.out.println("Task Completed: "+future.get());
        }

        exServicePool.shutdown();
        while (!exServicePool.isTerminated()) { }    // Checking if shutdown is complete, terminate() will return TRUE if all tasks after shutdown is completed.
        System.out.println("Finished all threads");
    }
}
