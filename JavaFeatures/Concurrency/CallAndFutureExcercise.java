package JavaFeatures.Concurrency;

import java.util.concurrent.*;

/**
 * Exercise Description:
 * <p>
 * 1. Modify the Task class created in 'ThreadPool - Exercise' to implement the “Callable” interface instead of Runnable. Add the following changes:
 * 2. Instead of implementing the run() method, the class should now implement call() method and invoke incrementCtr() method from within call() method and return “Integer” value of counter.
 * 3. In the main method, create two instances of the Task class.
 * 4. Submit both the task instances for execution to the executor (FixedThreadPool) and get their result values in the Future<Integer> objects and print the same.
 * 5. Observe the outcome.
 * </p>
 * */
class TaskThread implements Callable<Integer> {
    private int counter;

    public TaskThread(int counter){
        this.counter = counter;
    }

    private int incrementCtr(){
        return counter++;
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

class TaskThreadRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TaskThread task1 = new TaskThread(0);
        TaskThread task2 = new TaskThread(5);

        // Creating FixedSizeThreadPool
        ExecutorService exServicePool = Executors.newFixedThreadPool(2);  // Try changing  no of Threads here (1 and 2)

        // Executing using submit() and storing in Future Objects
        Future<Integer> future1 = (Future<Integer>) exServicePool.submit(task1);
        Future<Integer> future2 = (Future<Integer>) exServicePool.submit(task2);

        int noOfUploadTasks = 3;

        for (int i=1; i<=noOfUploadTasks; i++){
            // Getting value form Future obj
            System.out.println("Task Completed: "+future1.get());
            System.out.println("Task Completed: "+future2.get());
        }

        exServicePool.shutdown();
        while (!exServicePool.isTerminated()) { }    // Checking if shutdown is complete, terminate() will return TRUE if all tasks after shutdown is completed.
        System.out.println("Finished all threads");
    }
}
