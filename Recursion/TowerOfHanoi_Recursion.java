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

/*
 Pseudo code
 ------------
START
        Procedure Hanoi(disk, source, dest, aux)

        IF disk == 1, THEN
        move disk from source to dest
        ELSE
        Hanoi(disk - 1, source, aux, dest)     // Step 1
        move disk from source to dest          // Step 2
        Hanoi(disk - 1, aux, dest, source)     // Step 3
        END IF

        END Procedure
        STOP
  ----------
 */