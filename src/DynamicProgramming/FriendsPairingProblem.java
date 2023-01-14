package DynamicProgramming;

import java.util.Scanner;

public class FriendsPairingProblem {
    static int mod = (int)(1e9+7);
    public static long countFriendWays(int n)
    {
        return countWays(n, new long[n+1]) % mod;
    }
    public static long countWays(int n, long[] dp){
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<= n; i++){

            dp[i] = (dp[i-1] % mod + (dp[i-2] % mod * (i-1)) % mod) % mod;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        System.out.println(countFriendWays(N));

    }
}
