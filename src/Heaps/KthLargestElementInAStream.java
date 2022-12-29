package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElementInAStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] ans =  kthLargest(arr,n,  k);

        for(int i = 0; i < ans.length; i++)
            System.out.print(ans[i]+" ");
    }

    static int[] kthLargest(int[] arr, int n,int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((t, o)->t-o);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k-1; i++){
            ans.add(-1);
        }
        for(int i = 0; i < k; i++){
            pq.add(arr[i]);
        }
        ans.add(pq.peek());
        for(int i = k; i < n; i++){

            if(pq.peek() < arr[i]){

                pq.remove();
                pq.add(arr[i]);
            }

            ans.add(pq.peek());
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
