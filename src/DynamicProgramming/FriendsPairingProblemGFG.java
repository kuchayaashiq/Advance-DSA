package DynamicProgramming;

import com.sun.jdi.ArrayReference;

import java.util.Arrays;

public class FriendsPairingProblemGFG {
    // Returns count of ways n people
    // can remain single or paired up.
    static int countFriendsPairings(int n)
    {
        int dp[] = new int[n + 1];
        // Filling dp[] in bottom-up manner using
        // recursive formula explained above.
        for (int i = 0; i <= n; i++) {
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }
    //RECURSION
    static int countFriendsPairings_recr(int n, int[] dp)
    {
        if (dp[n] != -1)
            return dp[n];

        if (n > 2)
            return dp[n] = countFriendsPairings_recr(n - 1,dp) + (n - 1) * countFriendsPairings_recr(n - 2, dp);
        else
            return dp[n] = n;
    }
    // Driver code
    public static void main(String[] args){
        int n = 4;
        int[] dp = new int[n+1];
        for (int i :dp)
            Arrays.fill(dp, -1);
        // recursion
        System.out.println(countFriendsPairings_recr(n,  dp));
        //Tabulation
        System.out.println(countFriendsPairings(n));
    }
}
