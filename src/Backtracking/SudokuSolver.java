package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SudokuSolver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        sc.close();
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
        if (isValidSudoku(board)) System.out.println(
                "correct"
        ); else System.out.println("incorrect");
    }
    private static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> cols = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !cols.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

    public static boolean canPlace(int row, int col, int num, char[][] board){
        // check row
        for(int i=row,j=0; j<9; j++){
            if(board[i][j]-'0'==num){
                return false;
            }
        }

        // check col
        for(int i=0, j=col; i<9; i++){
            if(board[i][j]-'0'==num){
                return false;
            }
        }

        int sr = (row/3)*3;
        int sc = (col/3)*3;
        // check subGrid
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(board[i][j]-'0'==num){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean fillSudoku(ArrayList<int[]> points, int idx, char[][] board){
        if(idx == points.size()){
            return true;
        }

        int[] curr_points = points.get(idx);
        int row = curr_points[0];
        int col = curr_points[1];

        for(int num=1; num<=9; num++){
            if(canPlace(row,col,num,board)==true){
                board[row][col] = (char)(num+'0');
                boolean ans = fillSudoku(points, idx+1, board);
                if(ans==true){
                    return true;
                }

                board[row][col]='.';
            }
        }

        return false;
    }

    public static void solveSudoku(char[][] board) {
        ArrayList<int[]> points = new ArrayList<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    points.add(new int[]{i,j});
                }
            }
        }

        fillSudoku(points,0,board);
    }
}
