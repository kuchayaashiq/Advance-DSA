package DynamicProgramming.TwoD_DP;

import java.util.Scanner;
/*
*
    Input
    4 4
    4 9 11 1
    2 1 4 5
    8 2 4 3
    7 1 2 1

    //output
    13
* */
public class MinimumPathSumLeetCode {

    // leetcode 64 ==============================================
    //RECURSION
    public static int minPath_rec(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        if (j + 1 < grid[0].length) {
            right = minPath_rec(grid, i, j + 1);
        }

        if (i + 1 < grid.length) {
            down = minPath_rec(grid, i + 1, j);
        }

        int ans = grid[i][j] + Math.min(right, down);

        return ans;
    }
        //MEMORIZATION
    public static int minPath_memo(int[][] grid, int i, int j, int[][] dp) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return dp[i][j] = grid[i][j];
        }
        if (dp[i][j] != 0) return dp[i][j];

        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        if (j + 1 < grid[0].length) {
            right = minPath_memo(grid, i, j + 1, dp);
        }
        if (i + 1 < grid.length) {
            down = minPath_memo(grid, i + 1, j, dp);
        }
        int ans = grid[i][j] + Math.min(right, down);

        return dp[i][j] = ans;
    }
    //TABULATION MOST OPTIMAL SOLUTION
    public static int minPath_tab(int[][] grid, int i, int j, int[][] dp) {
        for (i = grid.length - 1; i >= 0; i--) {
            for (j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int right = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;

                if (j + 1 < grid[0].length) {
                    right = dp[i][j + 1];//minPath_memo(grid, i, j+1, dp);
                }
                if (i + 1 < grid.length) {
                    down = dp[i + 1][j];  //minPath_memo(grid, i+1, j, dp);
                }
                int ans = grid[i][j] + Math.min(right, down);

                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }
    public static int minPath_tabString(int[][] grid, int i, int j, int[][] dp){
        int n = grid.length;
        int m = grid[0].length;

        String[][] sdp = new String[n][m];

        for(i=grid.length-1; i>=0; i--){
            for(j=grid[0].length-1; j>=0; j--){
                if(i==grid.length-1 && j==grid[0].length-1){
                    dp[i][j] = grid[i][j];
                    sdp[i][j] = "";
                    continue;
                }

                int right = Integer.MAX_VALUE;
                int down  = Integer.MAX_VALUE;

                if(j+1 < grid[0].length){
                    right = dp[i][j+1];//minPath_memo(grid, i, j+1, dp);
                }

                if(i+1 < grid.length){
                    down = dp[i+1][j];  //minPath_memo(grid, i+1, j, dp);
                }

                int ans = grid[i][j];

                if(right < down){
                    ans += right;
                    sdp[i][j] = "r" + sdp[i][j+1];
                } else {
                    ans += down;
                    sdp[i][j] = "d" + sdp[i+1][j];
                }

                dp[i][j] = ans;
            }
        }

        System.out.println(sdp[0][0]);
        return dp[0][0];
    }
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
            //RECURSION
        //int ans = minPath_rec(grid, 0 , 0);
             //MEMORIZATION
        int[][] dp = new int[n][m];
        //int ans = minPath_memo(grid, 0 , 0,dp);
            //TABULATION
       // return minPath_tab(grid,0, 0, dp);
        return minPath_tabString(grid,0,0,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(minPathSum(grid));
    }
}
