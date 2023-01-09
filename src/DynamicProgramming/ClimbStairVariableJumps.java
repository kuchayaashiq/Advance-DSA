package DynamicProgramming;

import java.util.Scanner;

public class ClimbStairVariableJumps {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(climbingStair(arr, 0));

        // Using DP Memorization
        int[] memo = new int[n + 1];
        System.out.println(climbingStairMemo(arr, 0, memo));
        int[] dp = new int[n + 1];
        System.out.println(climbingStair_Tabulation(arr, 0, dp));

    }

    // Dp Solution way 1
    private static int climbingStairMemo(int[] arr, int idx, int[] memo) {
        if(idx == arr.length){
            return memo[idx] = 1;
        }
        if (memo[idx] != 0)
            return memo[idx];
        int ans = 0;
        for (int jump = 1; jump <= arr[idx] ; jump++) {
            if (idx+jump <= arr.length)
                ans += climbingStairMemo(arr, idx+jump, memo);

        }
        return memo[idx] = ans;
    }
    // Dp Solution way 2
    private static int climbingStair_Tabulation(int[] arr, int idx, int[] memo) {
        for(idx = arr.length; idx >=0; idx--){
            if(idx == arr.length){
                memo[idx] = 1;
                continue;
            }
            int ans = 0;
            for (int jump = 1; jump <= arr[idx] ; jump++) {
                if (idx+jump <= arr.length)
                    ans += memo[idx + jump];

            }
            memo[idx] = ans;
        }
        return memo[0];
    }

    private static int climbingStair(int[] arr, int idx) {
        if(idx == arr.length){
            return 1;
        }
        int ans = 0;
        for (int jump = 1; jump <= arr[idx] ; jump++) {
            if (idx+jump <= arr.length)
                ans += climbingStair(arr, idx+jump);

        }
        return ans;
    }
}
