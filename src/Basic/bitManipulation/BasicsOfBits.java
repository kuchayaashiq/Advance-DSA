package bitManipulation;

import java.util.Scanner;

public class BasicsOfBits {
    /*
    Do below operations on a number.
        1. On the ith bit.
        2. Off the jth bit.
        3. Toggle the kth bit.
        4 Check the mth bit is On or Off.

    *
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        int OnMask = (1 << i);
        int OffMask = ~(1 << j);
        int tMask = (1 << k);
        int chMask = (1 << m);

        System.out.println(n | OnMask);
        System.out.println(n & OffMask);
        System.out.println(n ^ tMask);
        System.out.println((n & chMask) == 0? false: true);




    }
}
