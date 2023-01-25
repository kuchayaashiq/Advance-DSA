package bitManipulation;

import java.util.Scanner;

public class RotateBits1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        String num = "";
        while (n >0){
            int rem =  n%2;
           if(rem%2 == 1)
               num  ="1" + num;
           else
               num = "0" + num;
           n = n/2;
        }
        int remLen = 16 - num.length();
        while (remLen > 0 ){
            num = "0" +num;
            remLen--;
        }
        String s1 = num.substring(0, 16-d);
        String s2 = num.substring(16-d, num.length());
        String ans1 = s2 +s1;

        String s3 = num.substring(0,d);
        String s4 = num.substring(d, num.length());
        String ans2 = s4+s3;


        long ans = 0;

        // for(int i=0;i<32;i++)
        //   System.out.print(arr[i]);

        for(int i=0;i<16;i++){

            long power = (long)Math.pow(2,16-i);

            ans = ans + power*(num.charAt(i)-'0');
        }

        //System.out.println(num);
    }
}
