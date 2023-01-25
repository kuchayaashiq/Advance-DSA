package TwoDimensionalArray;

import java.util.Scanner;

public class SpiralTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int minr = 0;
        int minc = 0;
        int maxr = n - 1;
        int maxc = m - 1;
        int tne = n * m;    // total no  of elements in matrix
        int count = 0;
        while(count < tne){
            // left wall
            for (int i = minr, j = minc; i <= maxr && count < tne ; i++) {
                System.out.print(a[i][j] +" ");
                count++;
            }
            minc++;
            // bottom wall
            for (int i = maxr, j = minc; j <= maxc && count < tne ; j++) {
                System.out.print(a[i][j] +" ");
                count++;
            }
            maxr--;
            // right wall
            for (int i = maxr, j = maxc; i >= minr && count < tne; i--) {
                System.out.print(a[i][j] +" ");
                count++;
            }
            maxc--;

            // top wall
            for (int i = minr, j = maxc; j >= minc && count < tne; j--) {
                System.out.print(a[i][j] +" ");
                count++;
            }
            minr++;
        }
    }
}
