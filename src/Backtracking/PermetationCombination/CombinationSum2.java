package Backtracking.PermetationCombination;

import java.util.*;
/*
    Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
    where the candidate numbers sums to T. Each number in C may only be used once in the combination.
    Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
    Print Answer in sorted Manner.
    Input format:
    the first line contains integer n denoting number of elements in array
    the second line denotes the array space separated
    the third line denotes the target sum
    Output format:
    all combinations space separated and in sorted order

    Example 1:
    Input:
    7
    10 1 2 7 6 1 5
    8
    output:
    1 1 6
    1 2 5
    1 7
    2 6
* */
public class CombinationSum2 {
    public static void getCombinations(ArrayList<Integer> nums,int idx, int tar, int csum,
                                       ArrayList<ArrayList<Integer>>ans, ArrayList<Integer> curr){
        if(csum>tar){
            return;
        }
        if(idx == nums.size()){
            if(tar==csum){
                if(ans.contains(curr)){
                    return;
                }
                else{
                    ans.add(new ArrayList<>(curr));
                }
            }
            return;
        }
        //Include
        curr.add(nums.get(idx));
        getCombinations(nums, idx+1, tar, csum + nums.get(idx), ans, curr);
        curr.remove(curr.size() - 1);
        // not Include
        getCombinations(nums, idx+1, tar, csum,ans, curr);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int sum){

        Collections.sort(a);

        ArrayList<ArrayList<Integer>> ans =  new ArrayList<>();

        getCombinations(a,0, sum,0,ans, new ArrayList<>());
        return ans;
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> a=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            a.add(sc.nextInt());
        }
        int sum = sc.nextInt();

        ArrayList<ArrayList<Integer>> ans = combinationSum(a, sum);
        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for(int i=0;i<Math.min(o1.size(),o2.size());i++)
                    if(o1.get(i)!=o2.get(i))
                        return o1.get(i).compareTo(o2.get(i));

                return o1.size()>o2.size()?1:0;
            }
        });
        for(ArrayList<Integer> A : ans)
        {
            for(Integer B : A)
            {
                System.out.print(B+" ");
            }
            System.out.println();
        }

    }
}
