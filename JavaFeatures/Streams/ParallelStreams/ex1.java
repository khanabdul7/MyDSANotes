package JavaFeatures.Streams.ParallelStreams;

import java.util.stream.IntStream;

/***
 * Create a List of integer numbers varying from 1 -1000. First, convert it to a Stream, then filter the even numbers and print the count of elements in the Stream.
 *
 * Capture the time taken to do the above operation. (Note: Use System.currentTimeMillis() method to capture the system time before and after the given operation and subtract the time values to get the time taken to complete the task.)
 *
 * Now perform the same operations on a Parallel Stream and capture the time taken by the Parallel Stream to complete the given task.
 *
 * Compare and understand the efficiency of the Parallel Stream.
 */

public class ex1 {
    public static void main(String args[]){
        // IntStream is used to create int type of stream and range is used to specify the initial and last element in stream.
        IntStream numbers = IntStream.range(1,1000);
        long timeBefore = System.currentTimeMillis();
        System.out.println("------Normal-------");
        long result = numbers.filter(n -> n%2==0).count();
        System.out.println("Count of first 1000 no: "+result);
        long timeAfter = System.currentTimeMillis();
        System.out.println("Time taken by Normal Execution: "+(timeAfter - timeBefore)+ " ms");

        IntStream numbersP = IntStream.range(1,1000);
        long timeBeforeP = System.currentTimeMillis();
        System.out.println("------Parallel-------");
        long resultP = numbersP.parallel().filter(n -> n%2==0).count();
        System.out.println("Count of first 1000 no: "+result);
        long timeAfterP = System.currentTimeMillis();
        System.out.println("Time taken by Parallel Execution: "+(timeAfterP - timeBeforeP)+ " ms");
    }
}
