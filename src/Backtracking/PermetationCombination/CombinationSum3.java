package Backtracking.PermetationCombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
*       Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    Only numbers `1` through `9` are used.
    Each number is used at most once.
    Return a list of all possible valid combinations. The list must not contain the same combination twice,
    and the combinations may be returned in any order.

    Input Format
    Input is managed for you. (You are given k and n in the combinationSum3() function).

    Output Format
    Output is managed for you. (You can return the possible valid combinations in any order. The combinations
    will be automatically printed in sorted order).

    Example 1
    Input
    3 8
    Output
    1 2 5
    1 3 4
* */
public class CombinationSum3 {
    public static void getCombinations(int nums,int idx, int tar, int csum,
                                       List<List<Integer>>ans, List<Integer> curr,
                                       int count, int k){
        if(csum>tar){
            return;
        }
        if(idx == 9){
            if(tar==csum && count == k ){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        //Include
        curr.add(nums);
        getCombinations(nums+1, idx+1, tar, csum + nums, ans, curr,count+1, k);
        curr.remove(curr.size() - 1);
        // not Include
        getCombinations(nums+1, idx+1, tar, csum,ans, curr,count, k);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        //write your code here
        List<List<Integer>> ans =  new ArrayList<>();

        getCombinations(1,0, n,0,ans, new ArrayList<>(), 0, k);
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        List<List<Integer>> ans = combinationSum3(k,n);
        for(int i = 0 ; i < ans.size() ; ++i){
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
