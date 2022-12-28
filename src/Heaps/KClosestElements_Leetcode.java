package Heaps;

import java.util.*;

public class KClosestElements_Leetcode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int x = sc.nextInt();
        List<Integer> ans = findClosestElements(arr, k,x);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // add that element that has min distance using Max priorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer t , Integer o) ->{
            if(Math.abs(t - x) == Math.abs(o-x)){
                return o-t;
            }
            return (Math.abs(o-x) - Math.abs(t-x));
        });
        /*PriorityQueue<Integer> pq = new PriorityQueue<>((Integer t , Integer o) ->{
            if(Math.abs(t - x) == Math.abs(o-x)){
                return t - o;
            }
            return (Math.abs(t-x) - Math.abs(o-x));
        });*/
        for(int i: arr){
            pq.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (ans.size()<k){
            ans.add(pq.remove());
        }
        Collections.sort(ans);
        return ans;
    }
}
