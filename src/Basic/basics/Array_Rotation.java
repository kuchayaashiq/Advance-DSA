package Basic.basics;

import java.util.Scanner;

public class Array_Rotation {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Original array is ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }

        // rotate array by k times towards right
        for (int i = 0; i < k; i++){
            int j, last;
            last = arr[n-1];
            for ( j =n-1; j > 0; j--){
                arr[j] = arr[j-1];
            }
            arr[0] = last;
        }
        System.out.println();
        System.out.println("After rotation  array is ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
