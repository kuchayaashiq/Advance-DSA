package FunctionsAndArray;
    /*
        1. You are given a number n, representing the size of array a.
        2. You are given n numbers, representing elements of array a.
        3. You are given a number k.
        4. Rotate the array a, k times to the right (for positive values of k), and to
        the left for negative values of k.
        Input Format
        Input is managed for you
        Output Format
        Output is managed for you
        Constraints
        0 <= n < 10^4
        -10^9 <= a[i], k <= 10^9
        Sample Input
        5
        1 2 3 4 5
        3
        Sample Output
        3 4 5 1 2

     */
import java.util.Scanner;

public class RotateArrayByK {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        // n =  size of array
        int n = scn.nextInt();
        int[] arr = new int[n];
        // Elements of Array
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        //  k = No. of Elements to Rotate
        int k = scn.nextInt();
        rotate(arr, k);
        displayArray(arr);
        System.out.println();
    }

    private static void rotate(int[] arr, int k) {
        k = k % arr.length;
        if(k < 0)
            k = k + arr.length;


        // Rotate part 1
        reverseArray(arr, 0, arr.length - k - 1);
        //Rotate part 2
        reverseArray(arr, arr.length - k , arr.length - 1);

        // Rotate All
        reverseArray(arr, 0, arr.length - 1);
    }

    private static void reverseArray(int[] arr, int i ,  int j) {
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;

        }
    }
    private static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
    }
}
