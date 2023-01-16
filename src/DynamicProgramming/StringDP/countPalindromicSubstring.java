package DynamicProgramming.StringDP;

import java.util.Scanner;

public class countPalindromicSubstring {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(makePalindtomicSubstring(str));
    }

    private static int makePalindtomicSubstring(String str) {

        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for(int diag = 0; diag<n; diag++){
            for(int i=0,j=diag; j<n; i++,j++){
                if(diag==0){ // substrings of size always a pallindromw
                    dp[i][j] = true;
                } else if(diag == 1){ // substrings of size2
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = true;
                    }
                } else {
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = dp[i+1][j-1]; // if substring(i+1,j-1) is not a pallindrome, substring(i,j) is not a pallindrome and vice versa
                    }
                }
                if(dp[i][j]==true){
                    count++;
                }
            }
        }
        return count;

    }
}
