package Backtracking.Recursion;

import java.util.Scanner;

public class KnightTour {
    public static void main(String[] args) throws Exception     {
        Scanner scn = new Scanner(System.in);
        // size of chess board
        int n = scn.nextInt();

        // row position of Knight
        int r = scn.nextInt();

        //column position of Knight
        int c = scn.nextInt();
        int[][] chess = new int[n][n];
        printKnightsTour(chess, r, c, 1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int move)
    {
        // Write your code here
        if(r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0){
            return;
        }
        //if knight reaches all the cells of chess board
        else if(move == chess.length *chess.length){
            chess[r][c] = move;
            //print the chess board
            displayBoard(chess);
            // release the board
            chess[r][c] = 0;
            return;
        }
        //insert the move number into chess board
        chess[r][c] = move;

        // moves of Knight on Chess Board
        printKnightsTour(chess, r-2, c+1, move+1);
        printKnightsTour(chess, r-1, c+2, move+1);
        printKnightsTour(chess, r+1, c+2, move+1);
        printKnightsTour(chess, r+2, c+1, move+1);
        printKnightsTour(chess, r+2, c-1, move+1);
        printKnightsTour(chess, r+1, c-2, move+1);
        printKnightsTour(chess, r-1, c-2, move+1);
        printKnightsTour(chess, r-2, c-1, move+1);
        chess[r][c] = 0;
    }
    // Display the chess board
    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
