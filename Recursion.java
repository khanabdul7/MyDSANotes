public class Recursion {

    public static void main(String args[]){
        //calling
        int recursionResult = factorialWithRecursion(3);
        int result = factorialWithoutRecursion(3);
        System.out.println("using factorialWithRecursion "+recursionResult);
        System.out.println("using factorialWithoutRecursion "+result);
    }

    //with recursion
    public static int factorialWithRecursion(int num){
        if(num<=1)
            return 1;
        else
            return (num * factorialWithRecursion(num-1));
    }

    //without recursion
    public static int factorialWithoutRecursion(int num){
        int factorial = 1;
        for(int i=num; i>0; i--){
            factorial = factorial * i;
        }
        return factorial;
    }
}
