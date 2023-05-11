package DataStructures.Arrays;

/*
* 1. For Searching in sorted array we use Binary Search.
* 2. For Insertion in sorted array we need to shift elements from the pos where we need to add new element.
* 3. For Deletion in sorted array we need to 1st find element using Binary search then delete and at last shift the elements.
*
**/
public class Array_Search_InsertAndDelete_SortedArray {

    // 1. Searching using Binary Search.
    public static int searching(int[] arr, int key, int low, int high){
        int mid = 0;

        while(low<=high){
            mid=(low+high)/2;

            //if mid-element is same as key.
            if(arr[mid]==key)
                return mid;

            //if mid-element is smaller than key, update low as below.
            if(arr[mid]<key)
                low=mid+1;

            //if mid-element is greater than key, update high as below.
            else
                high=mid-1;
        }
        //if we reach here, that means element is not present.
        return -1;
    }

    // 2. insertion in sorted array.
    public static void insertSorted(int[] arr, int key, int n){
        int i;
        //Shifting elements until elements are greater than key.
        for( i=n; (i>=0 && arr[i]>key); i--)
            arr[i+1] = arr[i];
        // adding key acc.to its value
        arr[i+1] = key;

        System.out.println("After insertion of "+key);
        for(int a: arr)
            System.out.println(a);
    }

    // 3. Deletion in sorted array
    public static void delete(int[] arr, int key, int n){

        //finding position of key
        int pos = searching(arr,key,0,n);

        if(pos == -1)
            System.out.println("Element not found for deletion!");

        //Shifting towards delete pos from end of array.
        for(int i=pos; i<n; i++)
            arr[i]= arr[i+1];

        //printing
        System.out.println("After Deletion of "+key);
        for (int i=0; i<arr.length-1; i++)
            System.out.println(arr[i]);
    }
    public static void main(String[] args){
        int[] arr = {1,3,5,7,9};
        //calling search
        int result = searching(arr,1,0,arr.length-1);
        if(result == -1)
            System.out.println("Element not found!");
        else
            System.out.println("Element found at index "+result);

        //calling insertion
        int[] newArr = new int[6];
        newArr[0]=1;
        newArr[1]=3;
        newArr[2]=5;
        newArr[3]=7;
        newArr[4]=9;
        insertSorted(newArr,4, arr.length-1);

        // calling delete
        delete(arr,5,arr.length-1);
    }
}
