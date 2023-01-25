package Patterns;
/*
        1. You are given a number n.
        2. You've to create a pattern of * and separated by tab as shown in output format.
        Input Format
        A number n
        Output Format
                *
            *		*
        *				*
            *		*
                *
        Constraints
        1 <= n <= 100
         Also, n is odd.
        Sample Input
        5
        Sample Output
                *
            *		*
        *				*
            *		*
                *
 */
import java.util.Scanner;

public class pattern10 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int osp =n/2, isp = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= osp; j++){
                System.out.print("\t");
            }
            System.out.print("*");
            for(int j = 1; j <= isp; j++){
                System.out.print("\t");
            }
            if(i > 1 && i < n)
                System.out.print("*");
            if(i <= n/2){
                osp--;
                isp +=2;
            }
            else{
                osp++;
                isp -=2;
            }
            System.out.println();
        }
    }

}
