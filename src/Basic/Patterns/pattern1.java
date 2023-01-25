package Patterns;

import java.util.Scanner;
/*
*   1.You are given a number n.
    2. You've to create a pattern of * and separated by tab as shown in output format.
    Input Format
    A number n
    Output Format
    *
    *	*
    *	*	*
    *	*	*	*
    *	*	*	*	*
   Sample Input
    2
    Sample Output
    *
    *	*
* */
public class pattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++ ){
            for(int j = 1; j <= i; j++ ){
                System.out.print("*\t");
            }
            System.out.println();

        }
    }
}
