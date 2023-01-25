package DynamicProgramming;

import java.util.Scanner;

public class Paint2x1 {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = solve(n);
        System.out.println(ans);

        sc.close();

    }
    static int mod = (int)(1e9+7);
    public static long solve(int n) {
        // Your code here
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1]%mod + dp[i-2]%mod)%mod;
        }
        return dp[n];
    }
}
