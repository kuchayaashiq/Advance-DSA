package DynamicProgramming.StringDP;

import java.util.Scanner;

public class SubsequenceCounting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(numberOfOccurrences(s1,s2));
    }
    public static int numberOfOccurrences(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n+1][m+1];

        // If first string is empty
        for (int i = 0; i <= m; ++i)
            dp[0][i] = 0;

        // If second string is empty
        for (int i = 0; i <= n; ++i)
            dp[i][0] = 1;

        // Fill dp[][] in
        // bottom up manner

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m; j++) {
                // If last characters are
                // same, we have two options -
                // 1. consider last characters
                //    of both strings in solution
                // 2. ignore last character
                //    of first string
                char c1 = s.charAt(i-1);
                char c2 = p.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }
                else {
                    // If last character are
                    // different, ignore last
                    // character of first string
                    dp[i][j] = dp[i-1][j];
                }

            }

        }
        System.out.println(dp[n][m] % (int)(1e9+7));
        return dp[n][m] % (int)(1e9+7);
    }
}
