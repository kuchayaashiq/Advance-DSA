package basic;

import java.util.Scanner;

public class IamBoredWithLife {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a =sc.nextInt();
        int b = sc.nextInt();
       int gcd = CalculateGCD(a,b);
        System.out.println(gcd);
    }

    private static int CalculateGCD(int a, int b) {
        int fa = factorial(a);
        int fb = factorial(b);
        int gcd =0;
        for (int i = 1; i <= fa && i <= fb ; i++) {
            if(fa % i == 0 && fb % i == 0)
                gcd =i;
        }
        return gcd;
    }

    private static int factorial(int num) {
        if(num == 1)
            return num;
        else
            return (num *factorial(num-1));
    }
}
