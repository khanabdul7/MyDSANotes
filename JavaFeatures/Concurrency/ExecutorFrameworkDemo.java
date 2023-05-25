package JavaFeatures.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Java provides us a 'Executor' Framework for concurrency management of Threads.
 *
 * */

class UploadResult extends Thread {
    @Override
    public void run() {
        //code for uploading result
        System.out.println("Upload Successful");
    }
}
public class ExecutorFrameworkDemo {
    public static void main (String[] args){
        ExecutorService exService = Executors.newSingleThreadExecutor(); // Creating a Single Thread Executor.
        UploadResult uploadRunnable1 = new UploadResult();  // Creating Instance of UploadResultThread.
        UploadResult uploadRunnable2 = new UploadResult();
        exService.execute(uploadRunnable1); // Calling execute() of Executor, execute() will internally call run() of Thread class.
        exService.execute(uploadRunnable2);
        exService.shutdown();
    }

}
