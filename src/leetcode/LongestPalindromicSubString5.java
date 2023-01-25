package leetcode;

import java.util.Scanner;

public class LongestPalindromicSubString5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		boolean[][] dp = new boolean[str.length()][str.length()];
		String ans = "";
		String temp = "";
		for (int g = 0; g < str.length(); g++) {
			for (int i = 0,j = g; j < dp.length; i++, j++) {
				if(g == 0) {
					dp[i][j] = true;
				}
				else if (g == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = true;
					}
					else {
						dp[i][j] = false;
					}
				}
				else {
					if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
						dp[i][j] = true;
					}
					else {
						dp[i][j] = false;
					}
				}
				
				if(dp[i][j]) {
					 temp = str.substring(i, j+1);
					 if(ans.length() < temp.length()) {
						 ans = temp;
					 }
				}			
				
			}
		}
		System.out.println(ans);

	}
}
