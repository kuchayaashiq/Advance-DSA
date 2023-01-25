package sorting;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        InsertionSort Is = new InsertionSort();
        Is.insertionSort(arr,n);
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i]+ " ");
//        }
    }

    private void insertionSort(int[] arr, int n) {
        int num,j;
        for (int i = 0; i < n; i++) {
            num = arr[i];
            for (j = i-1; j>=0 && arr[j] >num; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = num;
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k]+ " ");
            }
            System.out.println();

        }
    }
}
