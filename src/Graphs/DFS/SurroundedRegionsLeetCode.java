package Graphs.DFS;

import java.util.Scanner;

public class SurroundedRegionsLeetCode {

    public static void convert(int i, int j, char[][] board){
        board[i][j]='#';

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]=='O'){
                convert(x,y,board);
            }
        }
    }
    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(board[i][j]=='O')
                        convert(i,j,board);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                } else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
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
        solve(grid);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
