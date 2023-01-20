package DynamicProgramming;

import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(MatrixChainOrder(arr, n));
    }

    public static int mcm_rec(int[] arr, int si, int ei){
        if(si+1 == ei){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int cut=si+1; cut<ei; cut++){
            int left = mcm_rec(arr, si, cut);
            int right = mcm_rec(arr, cut, ei);

            int curr_ans = left + arr[si]*arr[cut]*arr[ei] + right;
            ans = Math.min(ans, curr_ans);
        }

        return ans;
    }

    public static int mcm_memo(int[] arr, int si, int ei, int[][] dp){
        if(si+1 == ei){
            return dp[si][ei] = 0;
        }

        if(dp[si][ei]!=0) return dp[si][ei];

        int ans = Integer.MAX_VALUE;
        for(int cut=si+1; cut<ei; cut++){
            int left = mcm_memo(arr, si, cut,dp);
            int right = mcm_memo(arr, cut, ei,dp);

            int curr_ans = left + arr[si]*arr[cut]*arr[ei] + right;
            ans = Math.min(ans, curr_ans);
        }

        return dp[si][ei] = ans;
    }

    public static int mcm_tab(int[] arr, int si, int ei, int[][] dp){
        int n = arr.length;

        for(int diag=1; diag<n; diag++){
            for(si=0, ei=diag; ei<n; si++,ei++){
                if(si+1 == ei){
                    dp[si][ei] = 0;
                    continue;
                }

                int ans = Integer.MAX_VALUE;
                for(int cut=si+1; cut<ei; cut++){
                    int left = dp[si][cut]; //mcm_memo(arr, si, cut,dp);
                    int right = dp[cut][ei]; //mcm_memo(arr, cut, ei,dp);

                    int curr_ans = left + arr[si]*arr[cut]*arr[ei] + right;
                    ans = Math.min(ans, curr_ans);
                }

                dp[si][ei] = ans;
            }
        }

        return dp[0][n-1];
    }

    static int MatrixChainOrder(int arr[], int n) {
        int[][] memo = new int[n][n];

        // return mcm_memo(arr,0,n-1,memo);
        return mcm_tab(arr,0,n-1,memo);
        // return mcm_rec(arr,0,n-1);
    }
}
