package Basic.basic;

import java.util.Scanner;

public class SearchIn2DMatrix {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int t = scn.nextInt();

        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        int i = 0, j = m-1;
        while (i < n && j >= 0) {
            if (mat[i][j] == t) {
                System.out.print("TRUE");
                return;
            }
            if (mat[i][j] > t)
                j--;
            else
                i++;
        }
        System.out.print("FALSE");



    }
}
