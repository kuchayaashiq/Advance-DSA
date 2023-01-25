package Patterns;
    /*
    1. You are given a number n.
    2. You've to create a pattern of * and separated by tab as shown in output format.
    Input Format
    A number n
    Output Format
                *
        *	*	*
    *	*	*	*	*
        *	*	*
                *
    Constraints
    1 <= n <= 100
     Also, n is odd.
    Sample Input
    5
    Sample Output
           	*
        *	*	*
    *	*	*	*	*
        *	*	*
            	*
     */
import java.util.Scanner;

public class pattern5 {
    public static void main(String[] args) {

        // write ur code here
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int st = 1, sp = n/2;
        for(int i = 1; i <= n; i++){

            //prints the number of spaces required on the line
            for(int j = 1; j <= sp; j++){
                System.out.print("\t");
            }
            //prints the number of stars required on the line
            for(int j = 1; j <= st; j++){

                System.out.print("*\t");
            }
            if(i <= n/2){
                sp--;
                st +=2;
            }
            else{
                sp++;
                st -=2;
            }
            System.out.println();
        }

    }
}
