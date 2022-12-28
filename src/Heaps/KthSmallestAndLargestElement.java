package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
*
* Input Format
The first line contains an integer 'N' denoting the number of elements.
The Second line  contains 'N' space seprated integers denoting the elements of the array.
The Third line contains an integer 'K'.
Output Format
In line 1, print the Kth smallest element of array.
In line 2, print the Kth largest element of array.
Example 1
Input
6
7 10 4 3 20 15
4
Output
10
7
Explanation
10 is the 4th smallest element, and 7 is the 4th largest element.
Example 2
Input
 5
 11 5 12 6 13
 2
Output
6
12
Explanation
6 is the 2nd smallest element, and 12 is the 2nd largest element
* */
public class KthSmallestAndLargestElement {
    public static void main(String args[]){

        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int k;
        k=sc.nextInt();
        Solution obj= new Solution();
        obj.kSmallLarge(arr,n, k);
    }
}
 class Solution{

    public static void kSmallLarge( int arr [], int n, int k){
        //Write your code and print here
        int s = kthlargest(arr, n, k);
        int l = kthSmallest(arr, n, k);
        System.out.println(l);
        System.out.println(s);
    }
    public static int kthlargest(int[]nums, int n, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            pq.add(nums[i]);

            if(pq.size() > k){
                pq.remove();
            }
        }
        return pq.peek();
    }
    public static int kthSmallest(int[]nums, int n, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            pq.add(nums[i]);

            if(pq.size() > k){
                pq.remove();
            }
        }
        return pq.peek();
    }
}
