package basic;

import java.util.Scanner;

public class mergeeSort {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
        mergeeSort ms = new mergeeSort();
        ms.sorting(arr,0,n-1);
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }

    private void sorting(int[] arr, int lowIndex, int highIndex) {
        if(lowIndex<highIndex){
            int mid =lowIndex +(highIndex-lowIndex)/2;
            sorting(arr,lowIndex,mid);
            sorting(arr,mid+1,highIndex);
            merge(arr,lowIndex,mid,highIndex);
        }
    }

    private void merge(int[] arr, int lowIndex, int mid, int highIndex) {
        int n1 = mid-lowIndex+1;
        int n2 = highIndex-mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[lowIndex + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];
        int i = 0, j = 0;
        int k = lowIndex;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
