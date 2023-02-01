package basic;

import java.util.Scanner;

public class TriangularNumber {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int num  = sc.nextInt();
        boolean ans = triangularNumberCheck(num);
        System.out.println(ans);
    }

    private static boolean triangularNumberCheck(int num) {
        int sum =0;
        if(num <0)
            return false;
        for (int i = 0; sum<= num; i++) {
            sum +=i;
            if (sum == num)
                return true;

        }
        return false;
    }
}
