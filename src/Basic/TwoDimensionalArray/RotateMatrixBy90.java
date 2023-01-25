package TwoDimensionalArray;
/*
        1. You are given a number n, representing the number of rows and number of columns.
        2. You are given n*n numbers, representing elements of 2d array a.
        3. You are required to rotate the matrix by 90 degree clockwise and then display the contents using display function.
        *Note - you are required to do it in-place i.e. no extra space should be used to achieve it .*
        Input Format
        A number n
        e11
        e12..
        e21
        e22..
        .. n * n number of elements
        Output Format
        output is taken care of by display function
        Constraints
        1 <= n <= 10^2
        -10^9 <= e1, e2, .. n * n elements <= 10^9
        Sample Input
        4
        11 12 13 14
        21 22 23 24
        31 32 33 34
        41 42 43 44
        Sample Output
        41 31 21 11
        42 32 22 12
        43 33 23 13
        44 34 24 14
 */
import java.util.Scanner;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        //transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {  // traverse in upper triangular matrix
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // reverse columns
        for (int i = 0; i < n; i++) {
            int li = 0;
            int ri = a[i].length - 1;
            while(li < ri){
                int temp = a[i][li];
                a[i][li] = a[i][ri];
                a[i][ri] = temp;

                li++;
                ri--;
            }
        }
        // display
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]+ "  ");
            }
            System.out.println();
        }
    }
}
