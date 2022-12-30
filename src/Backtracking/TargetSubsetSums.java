package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TargetSubsetSums {
    public static void solve(int[] arr, int tar, int idx, int csum,ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans){
        if(csum>tar) return;
        if(idx == arr.length){
            if(tar==csum){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        // include
        curr.add(arr[idx]);
        solve(arr,tar,idx+1,csum+arr[idx],curr,ans);
        curr.remove(curr.size()-1);

        // not include
        solve(arr,tar,idx+1,csum,curr,ans);
    }

    private static ArrayList<ArrayList<Integer>> findSubsets(int[] arr, int tar) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        solve(arr,tar,0,0,curr,ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, tar;
        n = sc.nextInt();
        tar = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        ArrayList<ArrayList<Integer>> subsets = findSubsets(arr, tar);
        Collections.sort(subsets, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        if (subsets.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < subsets.size(); i++) {
                for (int j = 0; j < subsets.get(i).size(); j++)
                    System.out.print(subsets.get(i).get(j) + " ");
                System.out.println();
            }
        }
        sc.close();
    }


}
