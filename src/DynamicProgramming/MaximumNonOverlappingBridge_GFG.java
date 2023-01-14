package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumNonOverlappingBridge_GFG {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        System.out.println(nonOverlappingBridges(arr));
    }

    private static int nonOverlappingBridges(int[][] bridges) {
        // sort the array on the basis of ist column
        Arrays.sort(bridges, (int[] t, int[] o)->{
            return t[0] - o[0];
        });
        int n = bridges.length;
        int[] dp = new int[n];
        int ans = 0;
        // run loop for 2nd element
        for(int i=0; i<n; i++){
            dp[i]=1;

            for(int j=i-1; j>=0; j--){
                if(bridges[i][1] > bridges[j][1]){ // is addition of ith point possible after jth point
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
