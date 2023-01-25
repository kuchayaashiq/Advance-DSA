package Patterns;

import java.util.Scanner;
    /*
    1. You are given a number n.
    2. You've to create a pattern of * and separated by tab as shown in output format.
    Input Format
    A number n
    Output Format
    *	*	*	*	*
    *	*	*	*
    *	*	*
    *	*
    *
    Sample Input
    5
    Sample Output
    *	*	*	*	*
    *	*	*	*
    *	*	*
    *	*
    *
     */
public class pattern2 {
    public static void main(String[] args) {

        // write ur code here
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =n; i >= 1; i--){
            for(int j =1; j <= i; j++){
                System.out.print("*	");
            }
            System.out.println();
        }
    }
}
