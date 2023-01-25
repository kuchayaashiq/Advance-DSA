package FunctionsAndArray;
    /*
    Question:

        1. You are given a base b.
        2. You are given two numbers n1 and n2 of base b.
        3. You are required to add the two numbers and print their value in base b.
        Input Format:
        A base b
        A number n1
        A number n2
        Output Format:
        A number representing the sum of n1 and n2 in base b.
        Constraints:
        2 <= b <= 10
        0 <= n1 <= 256
        0 <= n2 <= 256
        Sample Input:
        8
        777
        1
        Sample Output:
        1000
     */
import java.util.Scanner;

public class AnyBaseAddition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();   // base of n1 and n2
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int dn = getValue(n1, n2, b);
        System.out.println(dn);
    }

    private static int getValue(int n1, int n2, int b) {
        int res = 0;
        int p = 1, c = 0;
        while(n1 > 0 || n2 > 0 || c > 0){
            // getting digit of n1;
            int d1  = n1 % 10;
            // getting digit of n1;
            int d2 = n2 % 10;
            // Adding d1 and d2 and carry
            int d = d1 + d2 + c;
            // updating carry if digit is greater tnan base b after addition of d1 and d2;
            c = d /b;
            // updating the digit  for  correct value
            d = d % b;
            // storing the value
            res =  res + d * p;
            // updating the place values of new digit that comes
            p = p * 10;
            // updating n1
            n1 =  n1 / 10;
            // updating n2
            n2 =  n2 / 10;
        }
        return res;
    }
}
