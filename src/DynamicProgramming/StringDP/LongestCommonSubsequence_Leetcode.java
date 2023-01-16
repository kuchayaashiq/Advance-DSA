package DynamicProgramming.StringDP;

import java.util.Scanner;

public class LongestCommonSubsequence_Leetcode {
    // longest common subsequence ===============================================
    public static int rec_lcs(int n, int m, String s1, String s2){
        if(n==0 || m==0){
            return 0;
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return rec_lcs(n-1, m-1, s1, s2) + 1;
        } else {
            return Math.max(rec_lcs(n,m-1,s1,s2),rec_lcs(n-1, m, s1, s2));
        }
    }

    public static int rec_memo(int n, int m, String s1, String s2,int[][] dp){
        if(n==0 || m==0){
            return dp[n][m]=0;
        }

        if(dp[n][m]!=-1) return dp[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = rec_memo(n-1, m-1, s1, s2,dp) + 1;
        } else {
            return dp[n][m] = Math.max(rec_memo(n,m-1,s1,s2,dp),rec_memo(n-1, m, s1, s2,dp));
        }
    }

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

    static int lcs(int n, int m, String a, String b) {
        int[][] memo = new int[n+1][m+1];
        // for(int[] d:memo){
        //     Arrays.fill(d,-1);
        // }
        // return rec_memo(n,m,a,b,memo);
        // return rec_lcs(n,m,a,b);

        return lcs_tab(n, m, a, b, memo);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Take size of both the strings as input
        int n = scn.nextInt();
        int m = scn.nextInt();
        // Take both the string as input
        String a = scn.next();
        String b = scn.next();
        System.out.println(lcs(n, m, a, b));
    }
}
