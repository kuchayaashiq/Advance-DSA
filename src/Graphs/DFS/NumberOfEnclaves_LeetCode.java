package Graphs.DFS;

import java.util.Scanner;
/*
        Input Format
        First line consists of the number of rows m and columns n of the matrix mat
        The next m lines contains n integers each, either 0(sea) or 1(land)
        Output Format
        Print the number of land cells in grid for which we cannot walk off the boundary of the grid
        in any number of moves
        Example 1
        Input
        4 4
        0 0 0 0
        1 0 1 0
        0 1 1 0
        0 0 0 0
        Output
        3
* */
public class NumberOfEnclaves_LeetCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(numEnclaves(grid));
    }

    public static void convert(int i, int j, int[][] board){
        board[i][j]=0;

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]==1){
                convert(x,y,board);
            }
        }
    }
    public static int numEnclaves(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1)
                        convert(i,j,grid);
                }
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}
