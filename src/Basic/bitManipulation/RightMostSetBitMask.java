package bitManipulation;

import java.util.Scanner;

public class RightMostSetBitMask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rsbMask = (n &(~n+1));
        System.out.println(Integer.toBinaryString(rsbMask));

    }
}
