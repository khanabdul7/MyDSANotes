package Recursion;

public class Factorial_Recursion {

    public static void main(String args[]) {
        //calling methods
        int recursionResult = factorialWithRecursion(3);
        int result = factorialWithoutRecursion(3);
        System.out.println("using factorialWithRecursion " + recursionResult);
        System.out.println("using factorialWithoutRecursion " + result);
    }

    /*
     * With Recursion
     * No. of lines of code reduced but recursion is not suitable for memory optimization.
     */
    public static int factorialWithRecursion(int num) {
        if (num <= 1)
            return 1;
        else
            return (num * factorialWithRecursion(num - 1));
    }

    /*
    * Without Recursion
    * no of lines of code is more but its memory consumption is less as compared to recursion.
    */
    public static int factorialWithoutRecursion(int num) {
        int factorial = 1;
        for (int i = num; i > 0; i--) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
