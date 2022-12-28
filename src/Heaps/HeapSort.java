package Heaps;

import java.util.Scanner;

/*
* Input Format
The first line contains an integer N, the size of the array.
The second line contains N spaced integers, the elements of the array.
Output Format
Print the sorted array.
Expected Time Complexity: O(N*logN)
Example 1
Input
5
4 1 3 9 7
Output
1 3 4 7 9
Explanation
After sorting elements using heap sort, elements will be in order as 1,3,4,7,9.
Example 2
Input
10
10 9 8 7 6 5 4 3 2 1
Output
1 2 3 4 5 6 7 8 9 10
Explanation
After sorting elements using heap sort, elements will bein order as 1,2,3,4,5,6,7,8,9,10.
* */
public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.heapSort(arr1, n);
        for(int i=0;i<n;i++){
            System.out.print(arr1[i]+" ");
        }
    }

    static class Solution {
        void heapSort(int arr[], int n)
        {
            // write code here
            for(int i = n/2-1; i>=0; i--){
                Heapify(arr, n,i);
            }
            for(int i = arr.length-1; i>=0; i--){
                swap(arr, 0, i);
                Heapify(arr, i, 0);
            }
        }
        private void Heapify(int[] arr, int n, int pi) {
            int lci = 2*pi+1;
            int rci = 2*pi+2;
            int maxi = pi;
            if(lci < n && arr[lci] > arr[maxi]){
                maxi = lci;
            }
            if(rci < n && arr[rci] > arr[maxi]){
                maxi = rci;
            }
            if(maxi !=  pi){
                swap(arr,maxi, pi);
                Heapify(arr, n, maxi);
            }
        }
        private void swap(int[] arr, int ci, int pi) {
            int temp = arr[ci];
            arr[ci] = arr[pi];
            arr[pi]= temp;
        }
    }
}

