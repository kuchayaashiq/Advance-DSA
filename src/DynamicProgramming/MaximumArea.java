package DynamicProgramming;

import java.util.Scanner;
    /*
     Given an n x m binary matrix filled with 0's and 1's, find the largest square containing
     only 1's and return its area.
     Input Format
      The first line of the input contains n, and m, denoting the number of row and column in the matrix.
      The next n lines contain m space-separated integers represnting elements of the matrix.
      Output Format
            Return the maximum area of the square consisting only of ones.

            Example 1
            Input

            5 5
            0 1 1 1 0
            1 1 1 1 1
            0 1 1 1 1
            0 1 1 1 1
            0 0 1 1 1
            Output
            9
            */
public class MaximumArea {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char arr[][]=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int x= sc.nextInt();
                arr[i][j]=(char) (x+'0');
            }
        }
        System.out.println(maximalSquare(arr));

    }
    public static int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = matrix[i][j] - '0';
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(dp[i][j]==1){
                    int left = dp[i][j-1];
                    int top = dp[i-1][j];
                    int topLeft = dp[i-1][j-1];

                    dp[i][j] = Math.min(left,Math.min(top,topLeft)) + 1;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans=Math.max(ans,dp[i][j]);
            }
        }

        return ans*ans;
    }
}
