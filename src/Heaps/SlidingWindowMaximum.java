package Heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] ans =  maxSlidingWindow(arr, k);

        for(int i = 0; i < ans.length; i++)
            System.out.print(ans[i]+" ");
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b)-> b-a);
        int idx = 0;
        for (int i = 0; i < k; i++) {

            pq.add(nums[i]);
        }
        int[] ans = new int[nums.length-k+1];
        ans[idx++] = pq.peek();
        for (int i = k; i < nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.remove(nums[i-k]);
            ans[idx++] = pq.peek();
        }
        return ans;
    }
}
