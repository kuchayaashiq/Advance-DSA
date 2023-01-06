package DynamicProgramming;

import java.util.Scanner;
/*
*   Input: n = 2
    Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps
    Example 2:

    Input: n = 3
    Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step
* */
public class ClimbStair {
    private static int climbingStair(int n, int[] dp) {
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        System.out.println(climbingStair(n, dp));

    }
}
