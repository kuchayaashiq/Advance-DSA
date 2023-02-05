package Basic.basics;

import java.util.Scanner;

/*Explanation:
        Here n=148 and k=3 , so p=148148148.

        super_digit(p) = super_digit(148148148)
        = super_digit(1+4+8+1+4+8+1+4+8)
        = super_digit(39)
        = super_digit(3+9)
        = super_digit(12)
        = super_digit(1+2)
        = super_digit(3)
        = 3*/
public class DigitSumProblemUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int k = sc.nextInt();
        int sum =0;
        for(int i =0;i<n.length();i++){
            int a = Integer.parseInt(String.valueOf(n.charAt(i)));
            sum = sum+a;
        }
        int num = sum*k;
        int ans = super_digit(num);

        System.out.println("sum is : "+ans);

    }

    private static int super_digit(int num) {
        int sum = sumOfDigits(num);
        if(sum<10)
            return sum;
        int fsum = super_digit(sum);
        return fsum;
    }



    private static int sumOfDigits(int num) {
        int sum =0,rem;
        while (num>0){
            rem = num%10;
            sum +=rem;
            num = num/10;
        }
        return sum;
    }


}
