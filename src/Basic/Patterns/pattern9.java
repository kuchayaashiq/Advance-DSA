package Patterns;
/*
        1. You are given a number n.
        2. You've to create a pattern of * and separated by tab as shown in output format.
        Input Format
        A number n
        Output Format
        *		*
            *	    *
                *
            *	    *
        *		*
        Constraints
        1 <= n <= 100
         Also, n is odd.
        Sample Input
        5
        Sample Output
        *		*
            *	    *
                *
            *	    *
        *		*
 */
import java.util.Scanner;

public class pattern9  {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j || i + j == n + 1){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
