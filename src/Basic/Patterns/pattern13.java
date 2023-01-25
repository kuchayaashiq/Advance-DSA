package Patterns;
/*
        1. You are given a number n.
        2. You've to create a pattern as shown in output format



        Input Format
        A number n
        Output Format
        1
        1	1
        1	2	1
        1	3	3	1
        1	4	6	4	1
        1	5	10	10	5	1
        Constraints
        1 <= n <= 10
        Sample Input
        5
        Sample Output
        1
        1	1
        1	2	1
        1	3	3	1
        1	4	6	4	1
 */
import java.util.Scanner;

public class pattern13 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        for(int i = 0; i < n; i++){
            int icj = 1;
            for(int j = 0; j <= i; j++){
                System.out.print(icj +"\t");
                //  nC(k+1)=(nCk.(n-k))/(k+1).
                // 5C3 = 10; 5C4 = 5; 5C1 = 1
               int icj1 = (icj * (i-j))/(j+1);
               icj = icj1;
            }

            System.out.println();
        }
    }
}
