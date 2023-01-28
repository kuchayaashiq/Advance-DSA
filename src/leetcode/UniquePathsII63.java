/**
 * 
 */
package leetcode;

import java.util.Scanner;

/**
 * @author KUCHAY_AASHIQ
 *
 */
public class UniquePathsII63 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] obstacleGrid = new int[m][n];
		sc.close();
		int ans = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(ans);
	}
	static int dp[][];
    static int recur(int[][] obstacleGrid, int row, int col,int m,int n)
    {
        // out of the matrix, we simply return
        if(row == m || col == n)
        {
            return 0;
        }
        // Check Whether a last cell is Obstacle or not
        if(obstacleGrid[row][col] == 1 && row == (m-1) && col == (n-1)){
            return 0;
        }
     // Check for any middle cell is Obstacle or not
        if(obstacleGrid[row][col] == 1){
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
        int firstOption = recur(obstacleGrid, row+1,col,m,n);
        int secondOption = recur(obstacleGrid, row,col+1,m,n);
        
        int currentWays = firstOption+secondOption;
        dp[row][col] = currentWays;
        return currentWays;
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j] = -1;
            }
        }
        
        return recur(obstacleGrid,0,0,m,n);
    }

}
