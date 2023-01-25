package basic;

import java.util.Scanner;

public class TowerOfHanoi {
    static int steps =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TOH(n,'A','B','C');
        System.out.println(steps);
    }

    private static void TOH(int n, char a, char b, char c) {

        if(n==0)
            return;
        TOH(n-1,a,c,b);
        System.out.println(a+"-->"+c+" ");
        steps++;
        TOH(n-1,b,a,c);

    }


}
