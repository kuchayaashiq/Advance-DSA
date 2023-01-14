package DynamicProgramming;

import java.util.Scanner;

public class ClimbingStairsWithMinimumMoves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        System.out.println(climbingStair_Tabulation(arr, 0, dp));

    }
    private static int climbingStair_Tabulation(int[] arr, int idx, int[] memo) {
        int[] moves = new int[arr.length+1];
        for(idx = arr.length; idx >=0; idx--){
            if(idx == arr.length){
                memo[idx] = 1;
                moves[idx] = 1;
                continue;
            }
            int ans = 0;
            int move = Integer.MAX_VALUE;
            for (int jump = 1; jump <= arr[idx] ; jump++) {
                int m = 0;
                if (idx+jump <= arr.length) {
                    ans += memo[idx + jump];
                    m += moves[idx+jump];
                }
                move = Math.min(move, m);
            }
            memo[idx] = ans;
        }
        return memo[0];
    }
}
