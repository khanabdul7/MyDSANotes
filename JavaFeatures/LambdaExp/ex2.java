package JavaFeatures.LambdaExp;

/**
 * Create a main class that contains lambda expressions to implement the StringFormatter interface by defining the format() method in the following three different ways for the inputs: s1 = “Lambda”, s2 = “Expression”
 *
 * Returns "Lambda Expression"
 *
 * Returns "Lambda – Expression"
 *
 * Returns "LAMBDA EXPRESSION"
 * */
public class ex2 {
    public static void main(String args[]){
        String s1 = "Lambda";
        String s2 = "Expression";

        StringFormatter result = (v1, v2) -> v1+" "+v2; //Implementation
        System.out.println(result.format(s1,s2));  //Calling

        StringFormatter result1 = (v1, v2) -> v1+" - "+v2;
        System.out.println(result1.format(s1,s2));

        StringFormatter result2 = (v1, v2) -> v1.toUpperCase()+" "+v2.toUpperCase();
        System.out.println(result2.format(s1,s2));
    }
}
