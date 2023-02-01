package basic;

import java.util.Scanner;

public class GenerateAllParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char arr[] = new char[2*n];
        printParenthesis(arr,0,n,0,0);
    }

    private static void printParenthesis(char[] str, int pos, int n, int open, int close) {
        if (close == n) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println(" ");
            return;
        }
        else{
            if (open<n){
                str[pos] = '(';
                printParenthesis(str,pos+1,n,open+1,close);
            }
            if (open >close){
                str[pos] = ')';
                printParenthesis(str,pos+1,n,open,close+1);
            }

        }
    }
}
