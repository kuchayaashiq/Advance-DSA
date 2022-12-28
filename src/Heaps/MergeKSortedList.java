package Heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> ans = new ArrayList<>();

        // write your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] t, int[] o)->{
           return t[0 ] - o[0];
        });
        for (int i = 0; i < lists.size(); i++) {
            int data = lists.get(i).get(0);
            pq.add(new int[]{data, i, 0});
        }
        while (pq.size()>0){
            int[] top = pq.remove();
            int data = top[0];
            int li = top[1];
            int idx = top[2];

            ans.add(data);
            if(idx+1 < lists.get(li).size()){
                data = lists.get(li).get(idx+1);
                pq.add(new int[]{data, li, idx+1});
            }
        }
        return ans;
    }
}
