package Algorithms.Sorting;

/*  PSEUDO CODE
  1.  Run a nested for loop to traverse the input array using two variables i and j, such that 0 ≤ i < n-1 and 0 ≤ j < n-i-1
  2.  If arr[j] is greater than arr[j+1] then swap these adjacent elements, else move on
  3.  Print the sorted array

-----------------------------------------------------------------------------
---> Asked in
Microsoft, Wipro, SAP Labs, Cisco, Nagarro, redBus, Accenture, Huawei.
-----------------------------------------------------------------------------
Time Complexity: O(N^2)
Auxiliary Space: O(1)
-----------------------------------------------------------------------------
 */
public class BubbleSort {
    public static void sort(int[] arr){
        int temp;
        int pass = 0;
        //Nested for loop.
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j< arr.length-i-1;j++){
                //Swap if 1st element is greater than 2nd.
                if(arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            pass++;
        }
        System.out.println("Sorted arr: ");
        for(int a : arr)
            System.out.println(a);
        System.out.println("no of passes: "+pass);
    }

    public static void main(String[] args){

        int[] arr = {6,3,0,5,2,1,44,42};
        //calling
        sort(arr);
    }
}
