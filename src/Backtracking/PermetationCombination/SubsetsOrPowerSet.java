package Backtracking.PermetationCombination;

import java.util.*;
/*
              Input
                3
                2 1 2
              OutPut
                1
                1 2
                1 2 2
                2 
                2 2
*
* */
public class SubsetsOrPowerSet {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] ans = solve(N, arr);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] solve(int n, int[] nums){
        // Write your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(nums.length == 0){
            return new int[1][0];
        }
        Arrays.sort(nums);
        powerSet(nums, ans, 0, new ArrayList<Integer>());
        //Insert the array list elements into 2D array
        int[][] result = new int[ans.size()][];
        for(int i=0;i<ans.size();i++){
            result[i] = new int[ans.get(i).size()];
            for(int j=0;j<ans.get(i).size();j++){
                result[i][j] = ans.get(i).get(j);
                // System.out.print(result[i][j]);
            }
            //System.out.println();
        }
        return result;

    }
    public static void powerSet(int[] arr, ArrayList<ArrayList<Integer>> ans,
                                int idx,ArrayList<Integer> curr ) {
        // write your code here

        if (idx == arr.length) {
            return;
        }

        //include
        for(int i= idx; i < arr.length; i++){
            curr.add(arr[i]);
            ans.add(new ArrayList(curr));
            powerSet(arr, ans, i+1, curr);
            curr.remove(curr.size()-1);
            //notInclude
            //powerSet(arr, ans, idx+1, curr);
            while(i < arr.length - 1 && arr[i] == arr[i+1]){
                i++;
            }
        }

    }
}
