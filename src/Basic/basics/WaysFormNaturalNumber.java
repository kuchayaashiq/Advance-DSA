package basic;

import java.util.Scanner;

public class WaysFormNaturalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = WaysSum(n,1);
        System.out.print(ans);
    }

    private static int WaysSum(int n, int start) {
        if(n==0)
            return 1;
        int count =0;
        for (int i = start; i <= n; i++) {
            count += WaysSum(n-i,i+1);
        }
        return count;
    }
}
