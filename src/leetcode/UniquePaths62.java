/**
 * 
 */
package leetcode;

import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *		62. Unique Paths
		There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
		
		Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
		
		The test cases are generated so that the answer will be less than or equal to 2 * 109.
		Example 1:
		
		Input: m = 3, n = 7
		Output: 28
		Example 2:
		
		Input: m = 3, n = 2
		Output: 3
		Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
		1. Right -> Down -> Down
		2. Down -> Down -> Right
		3. Down -> Right -> Down
		
 */
public class UniquePaths62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		int ans = uniquePaths(m,n);
		System.out.println(ans);
	}
	    static int dp[][];
	    static int recur(int row, int col,int m,int n)
	    {
	        // out of the matrix, we simply return 0
	        if(row == m || col == n)
	        {
	            return 0;
	        }
	        
	        // we found out 1 way
	        if(row == (m-1) && col == (n-1))
	        {
	            return 1;
	        }
	        
	        // if answer for some row & col (it is calculated then return that answer)
	        if(dp[row][col]!=-1)
	        {
	            return dp[row][col];
	        }
	        
	        // 
	        int firstOption = recur(row+1,col,m,n);
	        int secondOption = recur(row,col+1,m,n);
	        
	        int currentWays = firstOption+secondOption;
	        dp[row][col] = currentWays;
	        return currentWays;
	    }
	    public static int uniquePaths(int m, int n) {
	        dp = new int[m][n];
	        for(int i=0;i<m;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                dp[i][j] = -1;
	            }
	        }
	        
	        return recur(0,0,m,n);
	    }

}
