package Patterns;
    /*
    1. You are given a number n.
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
    5
    Sample Output
                    *
                *	*
            *	*	*
        *	*	*	*
    *	*	*	*	*
     */
import java.util.Scanner;

public class pattern3 {
    public static void main(String[] args) {

        // write ur code here
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int sp = n - 1, st = 1;
        for(int i = 1; i <= n; i++){

            //prints the number of spaces required on the line
            for(int j = 1; j <= sp; j++){
                System.out.print("	");
            }
            //prints the number of stars required on the line
            for(int j = 1; j <= st; j++){

                System.out.print("*	");
            }
            sp--;
            st++;
            System.out.println();
        }

    }
}
