package JavaFeatures.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** ThreadPool
 * Using Executors, we can create a fixed ThreadPool by giving no of fixed Thread it have. These Threads remain idle in pool
 * until some tasks are assigned to them and after performing tasks they will be again available for performing another task.
 * */

class UploadResultThread implements Runnable {
    private String taskName;
    public UploadResultThread(String name) {
        taskName = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) " + taskName);
        // Code for uploading result: Dummy implementation
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) { System.out.println(e.getMessage()); }
        System.out.println(Thread.currentThread().getName() + " (End) " + taskName);
    }
}

/**
 * here, we are assigning 3 tasks to 2 Threads. Run the program to see which Thread will perform the extra task (3rd)
 * */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService exServicePool = Executors.newFixedThreadPool(2);    // Creating a thread Pool of fix size 2
        int noOfUploadTasks = 3;    // Assuming we have 3 UploadResult task which needs to be processed
        for (int i = 1; i <= noOfUploadTasks; i++) {
            UploadResultThread uploadRunnable = new UploadResultThread("UploadResult:" + i);
            exServicePool.execute(uploadRunnable);
        }
        exServicePool.shutdown();  // Shutdown() will shut down the tasks already submitted in an orderly manner, but no new tasks are accepted.
        while (!exServicePool.isTerminated()) { }    // Checking if shutdown is complete, terminate() will return TRUE if all tasks after shutdown is completed.
        System.out.println("Finished all threads");
    }

}
