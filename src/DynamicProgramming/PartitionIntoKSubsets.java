package DynamicProgramming;

import java.util.Scanner;

public class PartitionIntoKSubsets {
    public static long kSubarrayWay(int n, int k) {
        //write your code herek
        long[][] dp = new long[k+1][n+1];
        for (int t = 1; t <= k; t++) {
            for (int p = 1; p <= n ; p++) {
                if (p < t) {
                    dp[t][p] = 0;
                } else if (p == t) {
                    dp[p][t] = 1;
                } else {
                    dp[t][p] = dp[t - 1][p - 1] + dp[t][p - 1] * t;
                }
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int K= sc.nextInt();

        System.out.println(kSubarrayWay(N,K));

    }
}
