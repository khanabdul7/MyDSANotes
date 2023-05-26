package JavaFeatures.Concurrency;

import java.util.concurrent.*;

/** DEFINITION:
 *      Callable -> Callable is similar to Runnable interface with an additional ability to return the object or throw the exception.
 *      Future -> Future represents the result returned after the callable task finishes execution.
 *
 * Callable Interface Methods:
 *      call() -> call() is the single method available in the Callable interface that represents the task needs to get completed by the thread.
 *                  The call() method uses generics to define its return type.
 *      As Runnable interface uses the run() method similarly Callable interface has call() method.
 *
 * Future Interface Methods:
 *     1. V get() -> It waits to complete the execution and then gets the result.
 *     2. boolean isCancelled()	-> If it is able to cancel before it gets completed normally then returns true.
 *     3. boolean cancel(boolean mayInterruptIfRunning ) -> Tries to cancel task execution.
 *     4. boolean isDone() -> Checks if the task is completed or not.
 *     5. V get(long timeout, TimeUnit unit) -> Waits till the given time and then gets the result, if available.
 *
 * Note: The Future object returned from a callable thread can be retrieved by using these methods of ExecutorService
 *
 *      1. <T> Future<T> submit(Callable<T> task) -> Submits a value-returning task for execution. It returns a future that has the results of the task pending.
 *      2. <T> List<Future<T>>invokeAll(Collection<? extends Callable<T>> tasks) -> Performs all the Callable tasks as a collection and returns a list of Futures objects holding their results and status when all tasks are completed.
 *      3. T invokeAny(Collection<? extends Callable<T>>tasks) -> Performs the given tasks, and returns the result of one that has successfully completed, if any (i.e. without throwing an exception).
 * */


class UploadResults implements Callable<Boolean> {  // Implementing Callable Interface.
    private String taskName;
    public UploadResults(String name) {
        taskName = name;
    }

    @Override
    public Boolean call() throws Exception {   // Invoking Call()
        System.out.println(Thread.currentThread().getName() + " (Start) " + taskName);
        // Code for uploading result: Dummy implementation
        Boolean retValue = null;
        try {
            Thread.sleep(2000);
            // code to Upload result
            // Set retValue to true
            retValue = Boolean.TRUE;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            // Set retValue to false
            retValue = Boolean.FALSE;  // Setting to FALSE is Exception occurs
        }
        System.out.println(Thread.currentThread().getName() + " (End) " + taskName);
        return retValue;
    }
}
public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService exService = Executors.newSingleThreadExecutor();
        UploadResults uploadCallable = new UploadResults("Batch 1");
        Future<Boolean> future = exService.submit(uploadCallable);    // Submit () -> Submits a value-returning task for execution. It returns a future that has the results of the task pending.
        try {
            System.out.println("Upload completed: " + future.get());
            exService.shutdown();
        }

        catch(InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }
}
