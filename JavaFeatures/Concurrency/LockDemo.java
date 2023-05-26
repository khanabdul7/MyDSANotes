package JavaFeatures.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/** LOCK
 * However, a limitation here is that synchronized threads might end up waiting indefinitely for the lock.
 * The java.util.concurrent.locks package provides an alternative to the synchronized keyword - the Lock interface.
 *
 * In Lock, we can use its tryLock() method to make sure threads wait for a specific time only.
 *
 * The Lock can be acquired in one method and released in another. In addition, synchronized can cover only one method or block.
 *
 * In Lock, we can set fairness to true so that the longest waiting thread is first locked. In addition, synchronized keywords do not provide fairness.
 *
 * Here are some methods in the Lock interface:
 *
 *  1. void lock() -> Waits until the lock is acquired.
 *  2. boolean tryLock() -> At the time of calling if it is free then the lock is acquired and it returns true, it will not wait to get the lock. It returns false if the lock is currently used by a different thread.
 *  3. boolean tryLock(long time, TimeUnit unit) -> Gets the lock if it is free in the given time of waiting and the current thread is not interrupted.
 *  4. void unlock() -> The lock will be released.
 *
 * Note: ReentrantLock implements a Lock interface.
 * It has an additional constructor where fairness policy (the longest waiting thread to acquire lock first) can be set to true.
 * */

class UploadResultWithLock implements Runnable {
    private ReentrantLock lock;
    private int resultCount;
    public UploadResultWithLock(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) - Results uploaded: " + resultCount);
        // Code for uploading result: Dummy implementation
        try {
            lock.lock(); // A Lock is used to synchronize the section that uploads the result and increases the counter.
            Thread.sleep(2000);
            resultCount++;
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            lock.unlock(); // Releasing the lock
        }
        System.out.println(Thread.currentThread().getName() + " (End) - Results Uploaded: " + resultCount);
    }
}

/**
 * Note: Run program and analyse output.
 * */
public class LockDemo {
    public static void main(String[] args) {
        ExecutorService exServicePool = Executors.newFixedThreadPool(2);    // Creating a thread Pool of size 2
        int noOfUploadsTask = 3;    // Assuming we have 3 UploadResult tasks which need to be processed
        ReentrantLock lock = new ReentrantLock();    // The lock to be used
        UploadResultWithLock uploadRunnable = new UploadResultWithLock(lock); // Creating instance of Thread class.
        for (int i = 1; i <= noOfUploadsTask; i++) {
            exServicePool.execute(uploadRunnable);
        }
        exServicePool.shutdown();
        while (!exServicePool.isTerminated()) { }
        System.out.println("Finished all threads");
    }
}
