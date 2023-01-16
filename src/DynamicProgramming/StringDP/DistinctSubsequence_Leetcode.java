package DynamicProgramming.StringDP;

import java.util.Scanner;

public class DistinctSubsequence_Leetcode {
    // leetcode 115 =================================================
    public int distinctSubs_rec(int n, int m, String s, String t){
        if(n<m){
            return 0;
        }
        if(m==0){
            return 1;
        }

        if(s.charAt(n-1)!=t.charAt(m-1)){
            return distinctSubs_rec(n-1, m, s, t);
        } else {
            return distinctSubs_rec(n-1, m-1, s, t) + distinctSubs_rec(n-1, m, s, t);
        }
    }

    public int distinctSubs_memo(int n, int m, String s, String t,int[][] dp){
        // if Ist string has less characters than 2nd string
        if(n<m){
            return dp[n][m] = 0;
        }
        // if 2nd string reaches to 0th character
        if(m==0){
            return dp[n][m] = 1;
        }
        if(dp[n][m]!=-1)
            return dp[n][m];
        // if two characters are not equal then decrement ist string by -1
        if(s.charAt(n-1)!=t.charAt(m-1)){
            return dp[n][m] = distinctSubs_memo(n-1, m, s, t,dp);
        }
        // If characters of two strings are equal
        // there are two choices  for 2nd string
        //either goto next character or remain their .
        else {
            return dp[n][m] = distinctSubs_memo(n-1, m-1, s, t,dp) +
                                                 distinctSubs_memo(n-1, m, s, t,dp);
        }
    }

    public static int distinctSubs_tab(int N, int M, String s, String t, int[][] dp){
        for(int n=0; n<=N; n++){
            for(int m=0; m<=M; m++){
                if(n<m){
                    dp[n][m] = 0;
                    continue;
                }
                if(m==0){
                    dp[n][m] = 1;
                    continue;
                }

                if(s.charAt(n-1)!=t.charAt(m-1)){
                    dp[n][m] = dp[n-1][m]; //distinctSubs_memo(n-1, m, s, t,dp);
                } else {
                    dp[n][m] = dp[n-1][m-1] + dp[n-1][m]; //distinctSubs_memo(n-1, m-1, s, t,dp) + distinctSubs_memo(n-1, m, s, t,dp);
                }
            }
        }

        return dp[N][M];
    }

    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] memo = new int[n+1][m+1];
        return distinctSubs_tab(n, m, s, t, memo);
        // for(int[] d:memo){
        //     Arrays.fill(d,-1);
        // }
        // return distinctSubs_memo(n,m,s,t,memo);
        // return distinctSubs_rec(n,m,s,t);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Take both the string as input
        String a = scn.next();
        String b = scn.next();
        System.out.println(numDistinct(a, b));
    }
}
