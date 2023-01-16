package DynamicProgramming.StringDP;

import java.util.Scanner;

public class MinimumNumberOfInsertionsForPalindromicSubstring {
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

    public static int minInsertions(String s) {
        // your code here
        int lps = lps_tab(s,  new int[s.length()][s.length()]);
        return s.length() - lps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        System.out.println(minInsertions(s));
    }
}
