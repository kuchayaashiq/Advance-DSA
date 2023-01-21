package DynamicProgramming.StringDP;

import java.util.Scanner;

public class LongestCommonSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(findLCS(s1,s2));
    }

    private static int findLCS(String s1, String s2) {

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);
                if(c1 != c2){
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                }

            }

        }
        return max;
    }
}
