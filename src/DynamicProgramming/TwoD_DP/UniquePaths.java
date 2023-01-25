package DynamicProgramming.TwoD_DP;

import java.util.Scanner;

public class UniquePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int r = sc.nextInt(), c = sc.nextInt();
            System.out.println(uniquePaths(r, c));
        }
        sc.close();
    }

    public static int uniquePaths(int m, int n) {
        // your code here
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
