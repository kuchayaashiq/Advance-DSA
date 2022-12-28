package Heaps;

import java.util.*;

public class TopKFrequentWords_LeetCode692 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i = 0; i < n;i++){
            words[i] = sc.next();
        }
        int k = sc.nextInt();
        List<String> ans = topKFrequent(words,k);
        for(String s : ans){
            System.out.print(s+" ");
        }

    }
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String str:words) {
            hm.put(str, hm.getOrDefault(str, 0)+1);
        }
        PriorityQueue<String > pq = new PriorityQueue<>((String t, String o) ->{
            if(hm.get(t) == hm.get(o)){
                return o.compareTo(t);
            }
            return hm.get(t) - hm.get(o);
        });

        for(String str :hm.keySet()) {
            pq.add(str);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        List<String> ans = new ArrayList<>();
        while (pq.size()>0){
            ans.add(pq.remove());
        }
        Collections.reverse(ans);
        return  ans;

    }
}
