package JavaFeatures.Streams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Given a list of numbers, return a list of the cube of each number. For example, given [1, 2, 3, 4, 5] you should return [1, 8, 27, 64, 125].
 *
 * Calculate the sum of the first 50 whole numbers using iterate() and reduce() methods of Stream.
 *
 * */
public class ex1 {

    public static void main(String args[]){

        // returning cube of numbers
        Arrays.asList(1,2,3,4,5).stream().map(n -> n*n*n).forEach(System.out::println);

        // Calculating sum of 1st 50 whole numbers
        int sum = Stream.iterate(0, i -> i<=50, i -> i+1).reduce(0, (e1,e2)->e1+e2);
        System.out.println("Sum of 1st 50 whole numbers: "+sum);
    }
}
