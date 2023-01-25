package bitManipulation;

import java.util.Scanner;

public class RotateBits {
    /*
    Rotate the binary representation of the integer N by D digits to the left as well as right
     */
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        String num ="";
        while(n > 0){
            int rem  = n%2;
            if(rem %2 == 1)
                num  = "1" + num;
            else
                num = "0" + num;
            n /=2;
        }
        int remLen = 16-num.length();
        while(remLen >0){
            num = "0" + num;
            remLen--;
        }

        String s1 = num.substring(0,d);
        String s2 = num.substring(d, num.length());
        String ansLeft = s2 + s1;

        System.out.println(ansLeft);

        String s3 = num.substring(0,16-d);
        String s4 = num.substring(16-d, num.length());
        String ansRight = s4 + s3;


        long ans1 = 0;
        for(int i=0;i<16;i++){

            long power = (long)Math.pow(2,15-i);

            ans1 = ans1 + power*(ansLeft.charAt(i)-'0');
        }
        System.out.println(ans1);
        long ans2 = 0;
        for(int i=0;i<16;i++){

            long power = (long)Math.pow(2,15-i);

            ans2 = ans2 + power*(ansRight.charAt(i)-'0');
        }
        System.out.println(ans2);
    }
}
