package Graphs.DFS;

import java.util.Scanner;

/*
        Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
        return the number of islands.
        An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
        You may assume all four edges of the grid are all surrounded by water.
        Example 1:
        Input:
            4 5
            1 1 1 1 0
            1 1 0 1 0
            1 1 0 0 0
            0 0 0 0 0
        Output: 1
        Example 2:
        Input:
            4 5
            1 1 0 0 0
            1 1 0 0 0
            0 0 1 0 0
            0 0 0 1 1
        Output: 3

 */
public class NumberOfIslands {

    // leetcode 200 (Number of islands) =================================================================
    public static void dfs(int i, int j, char[][] grid){
        grid[i][j] = '0'; // changing land to water

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] dir:dirs){
            int x = i+dir[0];
            int y =j + dir[1];

            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]=='1'){
                dfs(x,y,grid);
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(numIslands(grid));
    }

}
