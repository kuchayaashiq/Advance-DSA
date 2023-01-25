package FunctionsAndArray;

import java.util.Scanner;

public class ConvertAnyBaseToBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        int dn = getValue(n, sourceBase, destBase);
        System.out.println(dn);
    }

    private static int getValue(int n, int sourceBase, int destBase) {
        int dec = getValueInDecimal(n, sourceBase);
        int value = getValueInBase(dec, destBase);
        return  value;
    }

    private static int getValueInDecimal(int n, int sourceBase) {
        int res =0;
        int p = 0;
        while(n > 0){
            int rem = n % 10;
            n = n / 10;
            res = res + (rem * (int)Math.pow(sourceBase, p));
            p++;
        }
        return res;

    }

    public static int getValueInBase(int n, int b){
        // write code here
        int res = 0;
        int p = 1;
        while(n > 0){
            int rem = n % b;
            n = n / b;
            res = res + rem * p;
            p = p * 10;
        }
        return  res;
    }
}
