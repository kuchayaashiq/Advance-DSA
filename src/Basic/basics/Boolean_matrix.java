package basic;

import java.util.Scanner;

public class Boolean_matrix  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of rows and columns");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("Enter Elements of a boolean matrix ");
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int row[] = new int[m];
        for (int i = 0; i < m; i++) {
            row[i]= 0;
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if(arr[i][j] == 1){
                    row[i]=1;
               }
            }
        }
        // modifying the existing matrix.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if( row[i]== 1){
                   arr[i][j] =1;
               }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
