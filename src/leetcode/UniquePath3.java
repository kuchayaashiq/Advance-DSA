package leetcode;

import java.util.Scanner;
/*
You are given an m x n integer array grid where grid[i][j] could be:
1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square,
that walk over every non-obstacle square exactly once.

Example 1:
Input:
        1 0 0 0
        0 0 0 0
        0 0 2 -1
Output: 2
Explanation: We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Input:
1 0 0 0
0 0 0 0
0 0 0 2

Output: 4
Explanation: We have the following four paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:

Input:
0 1
2 0
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
            Note that the starting and ending square can be anywhere in the grid.

* */

public class UniquePath3 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] obstacleGrid = new int[m][n];
        sc.close();
        int ans = uniquePathsIII(obstacleGrid);
        System.out.println(ans);
    }
    private static int solve(int[][] grid, int sr, int sc, int zero){
        if(sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || grid[sr][sc] == -1){
            return 0;
        }
        if(grid[sr][sc] == 2){
            return zero == -1 ? 1:0;
        }
        grid[sr][sc] = -1;
        zero--;
        int total = solve(grid, sr+1, sc, zero) +
                solve(grid, sr, sc+1, zero) +
                solve(grid, sr-1, sc, zero) +
                solve(grid, sr, sc-1, zero);

        grid[sr][sc] = 0;
        zero++;
        return total;
    }
    public static int uniquePathsIII(int[][] grid) {
        int zero =0 , sr = 0, sc = 0;
        for(int i = 0; i <grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] ==0){
                    zero++;
                }
                else if(grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }
            }
        }
        return solve(grid, sr, sc, zero);
    }
}
