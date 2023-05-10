package DataStructures.Arrays;

/* PSEUDO CODE
---> First Approach(using mod)
  1. We will first take mod of K by N (K = K % N) because after every N rotation array will become the same as the initial array.
  2. Now, we will iterate the array from i = 0 to i = N-1 and check,
        If i < K, Print rightmost Kth element (a[N + i -K]).
        Otherwise, Print array after ‘K’ elements (a[i – K]).
--------------------------
*** Time complexity : O(n)
*** Auxiliary Space : O(1)
--------------------------

---> Second Approach(reverse arr 3 times)
  1. reverse only the last k elements.
  2. Second time we will reverse first n-k(n=size of array) elements.
  3. Finally, we will get our rotated array by reversing the entire array.
--------------------------
*** Time complexity : O(n)
*** Auxiliary Space : O(1)
--------------------------

    NOTE: This problem can also be done using techniques that we use in leftRotation ?. but not vice-versa ?
*/
public class Array_RightRotation {

   public static void rotateRight(int[] arr, int k, int N){
       k = k % N;
       for(int i=0; i<N; i++){
            if(i<k){
                System.out.println(arr[N+i-k]);
            }
            else{
                System.out.println(arr[i-k]);
            }
       }
   }

   public static void rotateUsing3Reverses(int[] arr, int k, int N){
      int i, j, temp = 0;
      k = k % N;
       // 1st reverse, only last k elements.
       for(i=N-k, j=N-1; i<j; i++, j--){
           temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp;
       }
       //2nd reverse, first N-k elements.
       for(i=0, j=N-k-1; i<j; i++, j-- ){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
       }
       //3rd, reverse entire arr.
       for(i=0, j=N-1; i<j; i++,j--){
           temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp;
       }
       System.out.println("Right rotation Using 3 reverses: ");
       for(int r: arr){
           System.out.println(r);
       }
   }

    public static void main(String[] args){
        int[] original = {1,2,3,4,5};

        System.out.println("Right rotation using mod: ");
        rotateRight(original,3, original.length);
        rotateUsing3Reverses(original,3, original.length);
    }
}
