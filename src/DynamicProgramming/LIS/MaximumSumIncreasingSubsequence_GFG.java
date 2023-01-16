package DynamicProgramming.LIS;

import java.util.Scanner;

public class MaximumSumIncreasingSubsequence_GFG {
    public static int maxSumIS(int nums[], int n)  {
        int[] dp = new int[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            dp[i]=nums[i];

            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){ // is addition of ith point possible after jth point
                    dp[i] = Math.max(dp[i],dp[j]+nums[i]);
                }
            }

            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)

            arr[i] = sc.nextInt();

        System.out.println(maxSumIS(arr, n));
    }
}
