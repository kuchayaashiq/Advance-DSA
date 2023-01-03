package Backtracking.PermetationCombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {

    public static void getPermutations(int[] nums,int idx, int tar, int csum, List<List<Integer>>ans, List<Integer> curr){
        if(csum>tar){
            return;
        }
        if(idx == nums.length){
            if(tar==csum){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        //Include
        curr.add(nums[idx]);
        getPermutations(nums, idx, tar, csum + nums[idx], ans, curr);
        curr.remove(curr.size() - 1);

        // not Include
        getPermutations(nums, idx+1, tar, csum,ans, curr);
    }
    public static List<List<Integer>> combinationSum(int[] nums, int target){
        //write your code here
        List<List<Integer>> ans =  new ArrayList<>();

        getPermutations(nums,0, target,0,ans, new ArrayList<>());
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> ans = combinationSum(nums, target);
        for (int i = 0; i < ans.size(); ++i) {
            Collections.sort(ans.get(i));
        }
        Collections.sort(ans, (o1, o2) -> {
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
        for (int i = 0; i < ans.size (); i++)
        {
            for (int j = 0; j < ans.get(i).size (); j++)
            {
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();

        }
    }
}
