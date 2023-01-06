package DynamicProgramming;

import java.util.Scanner;

public class FibonacciRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fab_recr(n));
    }

    private static int fab_recr(int n) {
        if(n == 0 || n==1){
            return n;
        }
        int ans = fab_recr(n-1)+fab_recr(n-2);
        return ans;
    }
}
