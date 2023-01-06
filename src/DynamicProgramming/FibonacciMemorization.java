package DynamicProgramming;

import java.util.Scanner;

public class FibonacciMemorization {

    //Time Complexity = O(n)
    //Space Complexity = O(n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[n+1];
        System.out.println(fab_recr(n, memo));
    }

    private static int fab_recr(int n, int[] memo) {
        if(n == 0 || n==1){
            return memo[n] = n;
        }
        if(memo[n] != 0){
            return memo[n];
        }
        int ans = fab_recr(n-1, memo)+fab_recr(n-2, memo);
        memo[n] = ans;
        return ans;
    }
}
