package Backtracking;

import java.util.Scanner;

public class NQueenProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nQueens(0, n, new boolean[n][n],"");
    }

    private static void nQueens(int row, int n, boolean[][] board, String asf) {
        if(row==n){
            System.out.println(asf);
            return;
        }

        for(int col=0; col<n; col++){
            if(isQueenSafe(row,col,board)==true){
                board[row][col] = true;
                nQueens(row+1, n, board, asf+"("+row+" , "+col+")");
                board[row][col] = false;
            }
        }
    }

    private static boolean isQueenSafe(int row, int col, boolean[][] board) {
        int n = board.length;

        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{-1,-1},{0,-1}};

        for(int rad=1; rad<n; rad++){
            for(int[] dir : dirs){
                int i = row + rad * dir[0];
                int j = col + rad * dir[1];

                if(i>=0 && j>=0 && i<n && j<n && board[i][j]==true)
                    return false;
            }
        }

        return true;
    }
}
