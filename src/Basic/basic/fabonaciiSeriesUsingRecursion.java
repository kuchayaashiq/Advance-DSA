package basic;

import java.util.Scanner;

public class fabonaciiSeriesUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = fabonacii(n);
        System.out.print(num);
    }

    private static int fabonacii(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int n1 =fabonacii(n-1);
        int n2 =fabonacii(n-2);
        int f3 = n1 +n2;
        return f3;

    }
}
