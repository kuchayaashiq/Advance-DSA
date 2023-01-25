package Patterns;

import java.util.Scanner;
/*
        1. You are given a number n.
        2. You've to create a pattern of * and separated by tab as shown in output format.
        Input Format
        A number n
        Output Format
                        *
                    *
                *
            *
        *
        Constraints
        1 <= n <= 100
        Sample Input
        5
        Sample Output
                        *
                    *
                *
            *
        *


 */
public class pattern8 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int sp = n-1, st = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            for(int j = 1; j <= st; j++){
                System.out.print("*");
            }
            sp--;
            System.out.println();
        }
    }
}
