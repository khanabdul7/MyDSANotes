package DataStructures.Arrays;

public class Array_InsertionAndDeletion {

    //Insertion
    public static void insert(char[] arr, char element, int position) {
        //Traversing array from the last position to where the element has to be inserted.
        for (int i = arr.length - 1; i >= position; i--) {
            arr[i] = arr[i - 1];
        }
        // insert the element at given position
        arr[position] = element;
    }

    //Deletion
    public static void delete(char[] arr, int position) {
        //Traversing array from the position where the element has to be deleted to end.
        for (int i = position; i < arr.length-1; i++) {
            arr[i] = arr[i + 1];
        }
        // last empty space will replace by 0
        arr[arr.length - 1] = '0';
    }

    public static void main(String args[]) {
        char arr[] = new char[6];
        arr[0] = 'A';
        arr[1] = 'B';
        arr[2] = 'C';
        arr[3] = 'D';
        arr[4] = 'E';

        System.out.println("Before insertion: ");
        for (char c : arr) {
            System.out.println(c);
        }
        //calling
        insert(arr, 'J', 2);
        System.out.println("After insertion: ");
        for (char c : arr) {
            System.out.println(c);
        }

        //calling
        delete(arr,2);
        System.out.println("After deletion: ");
        for (char c : arr) {
            System.out.println(c);
        }
    }

}
