package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubsetsOfArray {

    public static void solve(int[] arr,int idx,ArrayList<Integer> curr,ArrayList<ArrayList<Integer>> ans){
        ans.add(new ArrayList<>(curr));

        for(int i = idx; i< arr.length; i++){
            // include
            curr.add(arr[i]);
            solve(arr,i+1,curr,ans);
            // not include
            curr.remove(curr.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> subsets(int[] arr, int n) {
        //Write your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        solve(arr,0,curr,ans);
        return ans;
    }

    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            int []A=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            ArrayList <ArrayList<Integer>> res = subsets(A,n);
            Collections.sort(res, (o1, o2) -> {
                int m = Math.min(o1.size(), o2.size());
                for (int i = 0; i < m; i++) {
                    if (o1.get(i) == o2.get(i)){
                        continue;
                    }else{
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 1;
            });
            for (int i = 0; i < res.size (); i++)
            {
                for (int j = 0; j < res.get(i).size (); j++)
                {
                    System.out.print(res.get(i).get(j)+" ");
                }
                System.out.println();

            }
        }
    }
}
