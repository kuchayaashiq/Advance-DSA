package Patterns;

import java.util.Scanner;

/*
    * 1. You are given a number n.
    2. You've to create a pattern of * and separated by tab as shown in output format.
    Input Format
    A number n
    Output Format
    *
        *
            *
                *
                    *
    Sample Input
    5
    Sample Output
    *
        *
            *
                *
                    *

    * */
public class pattern7 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j){
                    System.out.print("*");
                    break;
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
