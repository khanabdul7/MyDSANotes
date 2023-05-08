package Recursion;

public class TowerOfHanoi_Recursion {
    //From tutorialsPoint, use debugger to understand flow of execution.

    static void towerOfHanoi(int n, char source, char dest, char aux) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + source + " to " + dest);
        } else {
            towerOfHanoi(n - 1, source, aux, dest); // Note: sequence of parameters also changed here
            System.out.println("Move disk " + n + " from " + source + " to " + dest);
            towerOfHanoi(n - 1, aux, dest, source); // Note: sequence of parameters also changed here
        }
    }

    // Driver code
    public static void main(String args[]) {
        int N = 3;
        // A, B and C are names of rods
        towerOfHanoi(N, 'A', 'C', 'B');
    }

}
