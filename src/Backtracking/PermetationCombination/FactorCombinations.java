package Backtracking.PermetationCombination;

import java.util.*;
/*
        Numbers can be regarded as product of its factors. For example,
        8 = 2*2*2;
          = 2*4;
        You are given an integer n, you have to return all possible combinations of its factors.
        Input Format
            A single line with the integer n (The number n is always non-prime)
        Output Format
            Return all possible combinations of its factors, printing is handled by the driver code.

        Example 1
        Input
        12
        Output
        2 2 3
        2 6
        3 4
        Explanation
        2*6 = 12
        2*2*3 = 12
        3*4 = 12
* */
class Solution {

    public List<List<Integer>> getFactors(int n) {
        // Write your code here
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(2,n,list,current);
        return list;
    }
    private static void solve(int start,int n,List<List<Integer>> list,List<Integer> current){
        if(n == 1){
            if(current.size() > 1){
                list.add(new ArrayList<>(current));
                return;
            }
        }
        for(int i = start ; i <=n ; i++){
            if(n % i == 0){
                current.add(i);
                solve(i,n/i,list,current);                                                               current.remove(current.size()-1);
            }
        }
    }
}
public class FactorCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> result = Obj.getFactors(n);
        Collections.sort(result, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++)
                System.out.print(result.get(i).get(j) + " ");
            System.out.println();
        }
        sc.close();
    }
}
