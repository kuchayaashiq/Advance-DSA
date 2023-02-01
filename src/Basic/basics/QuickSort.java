package basic;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        int low =0,high = n-1;
        quickSort(arr,low,high);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low<high){
            int i = partition(arr,low,high);
            quickSort(arr, low,i-1);
            quickSort(arr,i+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot =arr[high];
        int l = low-1;
        for (int i = low; i <= high-1; i++) {
            if(arr[i] < pivot){
                l=l+1;
                Swaps(arr,l,i);

            }
        }
        Swaps(arr,l+1,high);
        return l+1;
    }

    private static void Swaps(int[] arr, int i, int l) {
      int   temp = arr[i];
      arr[i] = arr[l];
      arr[l] = temp;
    }
}
