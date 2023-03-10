package FunctionsAndArray;

import java.util.Scanner;

public class BinarySearch {
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
        int l = 0;
        int h = arr.length - 1;

        while (l <= h) {
            int m = (l + h) / 2;
            if (data > arr[m]) {
                l = m + 1;
            } else if (data < arr[m]) {
                h = m - 1;
            } else {
                System.out.println(m);
                return;
            }
        }
        System.out.println(-1);
    }
}
