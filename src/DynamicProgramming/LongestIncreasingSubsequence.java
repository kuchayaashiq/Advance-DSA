package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    // O(n^2) solution
    public static int lengthOfLIS(int[] nums) {
        // Array to store longest length
        int[] dp =  new int[nums.length];
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            // store 1 everytime because minimum subsequence length is 1
            dp[i] = 1;
            //loop to traverse backwards from i-1 to 0
            for (int j = i-1; j >=0 ; j--) {

                // check present element is greater than previous element
                //if it is Store the longest length from previous element
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }

            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
    //Better Solution  O(nlogn) solution ==============================================
    private static int lengthOfLIS_Better(int[] arr) {

        int n =  arr.length;
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pos = findPos(dp, arr[i]);
            if(pos == dp.size()){
                dp.add(arr[i]);
            }
            else {
                dp.set(pos, arr[i]);
            }
        }
        System.out.println(dp);
        return dp.size();
    }

    private static int findPos(ArrayList<Integer> dp, int ele) {
        int left = 0;
        int right = dp.size()-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(dp.get(mid) < ele){
                left = mid +1;
            }
            else {
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scc = new Scanner(System.in);
        int n = scc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scc.nextInt();
       // O(n^2) Solution
        System.out.println(lengthOfLIS(arr));

        // O(nlogn) Solution----> Better Solution
        System.out.println(lengthOfLIS_Better(arr));
    }


}
