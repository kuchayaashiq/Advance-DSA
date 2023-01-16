package DynamicProgramming.LIS;

import java.util.Scanner;

public class NumberOfLongestIncreasingSubsequence_Leetcode {
    public static int findNumberOfLIS(int[] nums) {
        int n= nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];
        int maxLength = 0;
        int maxCount = 0;

        for(int i=0; i<n; i++){
            dp[i] = 1;
            count[i] = 1;

            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    } else if(dp[i] == dp[j]+1){
                        count[i] += count[j];
                    }
                }
            }

            if(dp[i] > maxLength){
                maxLength = dp[i];
                maxCount = count[i];
            } else if(dp[i] == maxLength){
                maxCount += count[i];
            }
        }

        return maxCount;
    }
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(findNumberOfLIS(arr));
    }
}
