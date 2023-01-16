package DynamicProgramming.StringDP;

import java.util.Scanner;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(longestPalindromicSubsequence(s));
        //longest palindromic subsequence with String as answer
        System.out.println(longestPalSubseq(s));
    }
    public static int longestPalindromicSubsequence(String str){
        int n = str.length();
            //Recursion --> gives TLE for Longer test Cases
       // return lps_recr(str, 0, n-1);
             // Memorization
        int[][] memo = new int[n][n];
//        return lps_memo(str, 0, n-1, memo);
            //Tabulation
        return lps_tab(str,  memo);

    }
    private static int lps_tab(String str, int[][] dp) {
        int n = str.length();
        for (int diag = 0; diag < n; diag++) {
            for (int i = 0, j = diag; j < n; i++, j++) {
                if (i == j){
                    dp[i][j]= 1;
                    continue;
                }
                if(str.charAt(i) == str.charAt(j)){
                    if (i+1 == j){
                        dp[i][j] =  2;
                    }
                    else {
                        dp[i][j] =dp[i+1][j-1] +2 ; //lps_memo(str, i+1, j-1, memo) +2;
                    }
                }
                else {
                    dp[i][j] =Math.max(dp[i][j-1], dp[i+1][j]);  //Math.max(lps_memo(str, i+1, j, memo), lps_memo(str, i,j-1, memo));
                }
            }
        }
        return dp[0][n-1];

    }
    private static int lps_memo(String str, int i, int j, int[][] memo) {
        if (i == j){
            return memo[i][j]= 1;
        }
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        if(str.charAt(i) == str.charAt(j)){
            if (i+1 == j){
                return memo[i][j] =  2;
            }
            else {
                return memo[i][j] =  lps_memo(str, i+1, j-1, memo) +2;
            }
        }
        else {
            return memo[i][j] =  Math.max(lps_memo(str, i+1, j, memo), lps_memo(str, i,j-1, memo));
        }
    }
    private static int lps_recr(String str, int i, int j) {
        if (i == j){
            return 1;
        }
        if(str.charAt(i) == str.charAt(j)){
            if (i+1 == j){
                return 2;
            }
            else {
                return  lps_recr(str, i+1, j-1) +2;
            }
        }
        else {
            return Math.max(lps_recr(str, i+1, j), lps_recr(str, i,j-1));
        }
    }

    // longest pallindromic subsequence with String as answer ==========

    public static String lps_tabString(String str, int i, int j, int[][] dp){
        int n = str.length();
        String[][] sdp = new String[n][n];

        for(int diag=0; diag<n; diag++){
            for(i=0,j=diag; j<n; i++,j++){
                if(i==j){
                    dp[i][j] = 1;
                    sdp[i][j] = str.charAt(i)+"";
                    continue;
                }

                if(str.charAt(i)==str.charAt(j)){
                    if(i+1 == j){
                        dp[i][j] = 2;
                        sdp[i][j] = str.substring(i, i+2);
                    } else {
                        dp[i][j] = dp[i+1][j-1] + 2;//lps_memo(str, i+1, j-1,dp) + 2;
                        sdp[i][j] = str.charAt(i) + sdp[i+1][j-1] + str.charAt(j);
                    }
                } else {
                    // dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]); //Math.max(lps_memo(str,i,j-1,dp),lps_memo(str, i+1, j,dp));
                    if(dp[i][j-1] > dp[i+1][j]){
                        dp[i][j] = dp[i][j-1];
                        sdp[i][j] = sdp[i][j-1];
                    } else {
                        dp[i][j] = dp[i+1][j];
                        sdp[i][j] = sdp[i+1][j];
                    }
                }
            }
        }

        return sdp[0][n-1];
    }

    static String longestPalSubseq(String str){
        int n = str.length();
        int[][] dp = new int[n][n];
        return lps_tabString(str, 0, n-1, dp);
    }

}
