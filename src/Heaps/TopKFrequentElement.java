package Heaps;

import java.util.*;

public class TopKFrequentElement {
    public static int[] KMostFrequentElements(int[] arr, int k) {
        // Write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i:arr) {
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Integer > pq = new PriorityQueue<>((t, o) ->hm.get(t)- hm.get(o));

        for(int i :hm.keySet()) {
            pq.add(i);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[] ans = new int[k];
        int j = 0;
        while (pq.size()>0){
            ans[j] = pq.remove();
            j++;
        }

        return  ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] ans = KMostFrequentElements(arr, k);
        Arrays.sort(ans);
        for(int a : ans)
            System.out.print(a + " ");
    }
}
