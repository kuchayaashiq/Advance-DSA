package basic;

import java.util.Scanner;



public class MergeSort {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        for (int k = 0; k < n; k++) {
            arr[k] = sc.nextInt();
        }
        mergeSorting(arr,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }

    }
    private static void mergeSorting(int[] arr, int low, int high) {
        int mid;
        if(low<high){
            mid = low+high/2;
            mergeSorting(arr,low,mid);
            mergeSorting(arr,mid+1,high);
            // merge two sorted halves of array
            merge(arr,low,mid,mid+1,high);
        }
    }
    static void merge(int[] arr, int l, int m, int m2,int h){
        int[] c= new int[arr.length];
        int i =l, j =m2,k=0;
        while (i<=m && j<=h){
            if(arr[i]<= arr[j])
                c[k++] = arr[i++];
            else
                c[k++] = arr[j++];
        }
        while(i<=m){
            c[k++] = arr[i++];
        }
        while (j<=h){
            c[k++] = arr[j++];
        }
        for (i=l,j=0; i <= h; i++,j++) {
            arr[i] =c[j];

        }
    }
}
