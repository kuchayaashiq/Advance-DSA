package FunctionsAndArray;
/*
        1. You are given a number n, representing the size of array a.
        2. You are given n numbers, representing elements of array a.
        3. You are required to calculate the inverse of array a.

        For definition and constraints check this link
        https://www.pepcoding.com/resources/online-java-foundation/getting-started/inverse-of-a-number/ojquestion
        The only difference is the range of values is from 0 to n - 1, instead of 1 to n.
        Input Format
        Input is managed for you
        Output Format
         Output is managed for you
        onstraints
        0 <= n < 10^7
        For more constraints check this
        https://www.pepcoding.com/resources/online-java-foundation/getting-started/inverse-of-a-number/ojquestion
        The only difference is the range of values is from 0 to n - 1, instead
        of 1 to n
        Sample Input
        5
        4 0 3 2 1
        Sample Output
        1 4 3 2 0 +
 */
import java.util.Scanner;

public class InverseArray {
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
        int[] inv = inverse(arr);
        displayArray(inv);
    }
    public static int[] inverse(int[] a){
        // write your code here
        int[] inv = new int[a.length];
        for(int i = 0; i < a.length; i++){
            int idx = a[i];
            inv[idx] = i;
        }
        return inv;
    }
    private static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
    }
}
