package basic;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        SecondLargest(arr,n);

    }

    private static void SecondLargest(int[] arr, int n) {
        if(n < 2 ){
            System.out.println("Size of Array Should be greater than 2");
            return;
        }
        Arrays.sort(arr);
        for (int i = n-2; i >=0 ; i--) {
            if(arr[i] !=arr[n-1]) {
                System.out.println(arr[i]);
                return;
            }

        }
        System.out.println("Second largest element is not possible");

    }
}
