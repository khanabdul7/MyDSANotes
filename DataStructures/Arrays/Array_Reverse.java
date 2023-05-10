package DataStructures.Arrays;

public class Array_Reverse {

    public static void reverse(int[] arr,int start, int end){
        int temp = 0;

        while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};

        System.out.println("Reverse array: ");
        reverse(arr, 0,4);

        //printing
        for(int i: arr){
            System.out.println(i);
        }
    }

}
