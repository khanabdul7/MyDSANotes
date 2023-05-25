package JavaFeatures.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Exercise Description:
 * Create a Task class by implementing the Runnable interface. Add the following in the class:-
 * A private data member “counter” of the type int.
 * Parameterized Constructor which takes an integer value as an argument and initializes the counter to the argument of the constructor.
 * Override the run() method to invoke another method incrementCtr() which increments the “counter” value by 1. Print the value of the counter within the run() method
 *
 * Create a new TaskRunner class and add a main() method. In the main() method, create two task class instances and perform the task with FixedThreadPool provided by the executor framework.
 * */
class Task implements Runnable{
    private int counter;

    public Task(int counter){
        this.counter = counter;
    }

    private int incrementCtr(){
       return counter++;
    }
    @Override
    public void run(){
        incrementCtr();
        System.out.println(Thread.currentThread().getName()+" Start ");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter: "+counter);
        System.out.println(Thread.currentThread().getName()+" End ");
    }
}

class TaskRunner {
    public static void main(String[] args){
        Task task1 = new Task(0);
        Task task2 = new Task(5);

        // Creating FixedSizeThreadPool
        ExecutorService exServicePool = Executors.newFixedThreadPool(2);  // Try changing  no of Threads here (1 and 2)
        exServicePool.execute(task1);
        exServicePool.execute(task2);

        exServicePool.shutdown();
        while (!exServicePool.isTerminated()) { }    // Checking if shutdown is complete, terminate() will return TRUE if all tasks after shutdown is completed.
        System.out.println("Finished all threads");
    }
}


