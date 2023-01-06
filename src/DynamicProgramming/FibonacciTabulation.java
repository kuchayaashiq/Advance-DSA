package DynamicProgramming;

import java.util.Scanner;

public class FibonacciTabulation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        System.out.println(Tabulation(n, dp));
        System.out.println(tab(n, dp));
    }

    private static int Tabulation(int n, int[] dp) {
        dp[0] = 0;
        dp[1]  = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    // Another Way of Tabulation
    private static int tab(int n, int[] dp){
        for (int i = 0; i <= n; i++) {
            if(i == 0 || i == 1){
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
