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
        int[] dp = new int[n + 1];
        System.out.println(climbingStairMemo(arr, 0, dp));

    }

    private static int climbingStairMemo(int[] arr, int idx, int[] dp) {
        if(idx == arr.length){
            return dp[idx] = 1;
        }
        if(dp[idx] != 0)
            return dp[idx];
        int ans = 0;
        for (int jump = 1; jump <= arr[idx] ; jump++) {
            if (idx+jump <= arr.length)
                ans += climbingStairMemo(arr, idx+jump, dp);

        }
        return dp[idx] = ans;
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
