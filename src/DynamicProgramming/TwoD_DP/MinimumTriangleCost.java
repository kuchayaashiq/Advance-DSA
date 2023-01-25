package DynamicProgramming.TwoD_DP;

import java.util.Scanner;
/*
     Question : Return the minimum score of a path from the top row to the bottom row.
            Input Format
            The first line contains a single integer n.
            The next n lines contain i + 1 integers each, where the jth integer in the ith
              line is the value of the cell at index j in row i.

            Output Format
            Print a single integer denoting the minimum score of a path from the
            top row to the bottom row.
            Example 1
            Input
            3
            2
            3 4
            6 5 7
            Output
            10
            */
public class MinimumTriangleCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(getMin_memo(arr, 0, 0, new int[n][n]));
    }
    public static int getMin_memo(int[][] arr, int i, int j, int[][] dp) {
        if (i == arr.length) {
            return 0;
        }
        if (dp[i][j] != 0)
            return dp[i][j];

        return dp[i][j] = arr[i][j] + Math.min(getMin_memo(arr, i+1, j, dp), getMin_memo(arr, i+1, j + 1, dp));

    }
}
