package basic;

import java.util.Scanner;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr1 = new int[n];
        for (int k = 0; k < n; k++) {
            arr1[k] = sc.nextInt();
        }
        int m =sc.nextInt();
        int[] arr2 = new int[m];
        for (int k = 0; k < m; k++) {
            arr2[k] = sc.nextInt();
        }
        int[] result = new int[n+m];
        int i=0,j=0,index=0;
        while (i<n && j<m){
            if(arr1[i]< arr2[j]){
                result[index++]= arr1[i++];
            }
            else
                result[index++]= arr2[j++];
        }
        while (i<n){
            result[index++]= arr1[i++];
        }
        while (j<m){
            result[index++]= arr2[j++];
        }

        for (int k = 0; k < result.length; k++) {
            System.out.print(result[k]+" ");
        }
    }
}
