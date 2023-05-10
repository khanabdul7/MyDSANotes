package DataStructures.Arrays;

/*
 ---> This was asked in Amazon, Microsoft.
*/
public class Array_LeftRotation {
    //Approach 1 (using temp arr), Time & space complexity is O(N)
    public static int[] rotateLeftUsingTempArr(int [] original, int position){
        int[] temp = new int[original.length];
        int i = 0;
        while(position < original.length){     //Storing elements to temp arr from given position till end of original arr.
            temp[i] = original[position];
            position++;
            i++;
        }
        int j = 0;
        while(i < temp.length){     //Storing remaining elements to temp arr.
            temp[i] = original[j];
            j++;
            i++;
        }
        return temp;    //Returning temp arr.
    }

    //Approach 2 (rotate 1 by 1), Time & space complexity is O(N)
    public static void rotateLeftOneByOne(int[] arr, int position){
        int temp = 0;

        while(position > 0){
            int i = 0;
            temp = arr[i];   //Storing 1st element in temp.
            while(i < arr.length-1) {
                arr[i] = arr[i + 1];  //Shifting 1 by 1 to left.
                i++;
            }
            position--;
            arr[i] = temp;   //Storing 1st element to last index of arr.
        }
        System.out.println("Left Rotation using 1by1: ");
        for(int a: arr){
            System.out.println(a);
        }
    }

    public static void main(String[] args){
        int[] original = {1,2,3,4,5};

        //Calling approach 1
        int[] arr = rotateLeftUsingTempArr(original,4);
        System.out.println("Left rotation using temp arr: ");
        for (int i: arr){   // printing temp arr
            System.out.println(i);
        }
        //Calling approach 2
        //rotateLeftOneByOne(original,3);
    }

}
