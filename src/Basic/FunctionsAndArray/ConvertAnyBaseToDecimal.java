package FunctionsAndArray;

import java.util.Scanner;

public class  ConvertAnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }
    public static int getValueInBase(int n, int b){
        // write code here
        int res = 0;
        int p = 0;
        while(n > 0){
            int rem = n % 10;    //Digit-stores remainder at each step
            n = n / 10;          // dividing the number by base number
            res = (int) (res + rem * Math.pow(b, p)); //placing digit at right place
            p++;     // increasing power; to the next place
        }
        return res;
    }
}
