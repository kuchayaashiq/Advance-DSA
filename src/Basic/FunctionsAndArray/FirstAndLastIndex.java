package FunctionsAndArray;
/*
        1. You are given a number n, representing the size of array a.
        2. You are given n numbers, representing elements of array a.

        Asssumption - Array is sorted. Array may have duplicate values.
                    If duplicate values are not present then print -1 and -1
        Input Format
        A number n
        n1
        n2
        .. n number of elements
        A number d
        Output Format
        A number representing first index
        A number representing last index
        Constraints
        1 <= n <= 1000
        1 <= n1, n2, .. n elements <= 100
        1 <= d <= 100
        Sample Input
        15
        1 5 10 15 22 33 33 33 33 33 40 42 55 66 77
        33
        Sample Output
        5
        9
 */
import java.util.Scanner;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        // n =  size of array
        int n = scn.nextInt();
        int[] arr = new int[n];
        // Elements of Array
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();

        // First Index
        int low = 0;
        int high = n - 1;
        int fi = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(data < arr[mid]){
                high = mid - 1;
            } else if (data > arr[mid]) {
                low = mid + 1;
            }
            else {
                fi = mid;
                high = mid -1;
            }
        }
        System.out.println(fi);

        // last index
        low = 0;
        high = n - 1;
        int li = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(data < arr[mid]){
                high = mid - 1;
            } else if (data > arr[mid]) {
                low = mid + 1;
            }
            else {
                li = mid;
                low = mid + 1;
            }
        }
        System.out.println(li);
    }
}
