package DynamicProgramming.StringDP;

import java.util.Scanner;
        /*
        Given two strings word1 and word2, return the minimum number of steps required to
        make word1 and word2 the same.
        In one step, you can delete exactly one character in either string.
        Example 1:
        Input: word1 = "sea", word2 = "eat"
        Output: 2
        Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
        */
public class DeleteOperationTwoStrings_Leetcode583 {
    public static int lcs_tab(int N, int M, String s1, String s2, int[][] dp){
        for(int n=0; n<=N; n++){
            for(int m=0; m<=M; m++){
                if(n==0 || m==0){
                    dp[n][m]=0;
                    continue;
                }

                if(s1.charAt(n-1) == s2.charAt(m-1)){
                    dp[n][m] = dp[n-1][m-1] + 1; //rec_memo(n-1, m-1, s1, s2,dp) + 1;
                } else {
                    dp[n][m] = Math.max(dp[n][m-1],dp[n-1][m]); //Math.max(rec_memo(n,m-1,s1,s2,dp),rec_memo(n-1, m, s1, s2,dp));
                }
            }
        }

        return dp[N][M];
    }

    static int minDistance(int n, int m, String a, String b) {
        int[][] memo = new int[n+1][m+1];
        int lcs =  lcs_tab(n, m, a, b, memo);
        return (n+m-2*lcs);

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Take size of both the strings as input
        int n = scn.nextInt();
        int m = scn.nextInt();
        // Take both the string as input
        String a = scn.next();
        String b = scn.next();
        System.out.println(minDistance(n, m, a, b));
    }
}
