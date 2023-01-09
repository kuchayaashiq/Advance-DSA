package DynamicProgramming;

import java.util.Scanner;

public class MinimumCostClimbingStair_Leetcode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        //Memorization
         int startWithZero = minCost_memo(cost,0, new int[cost.length+1]);
         int startWithOne = minCost_memo(cost,1, new int[cost.length+1]);
        System.out.println(Math.min(startWithZero,startWithOne));
        //------------------------------------------------
       // Tabulation
        System.out.println(minCost_tab(cost, new int[cost.length+1]));
        //---------------------------------------------------
        System.out.println(minCost_tab_mostOptimized(cost));
    }
    //Memorization
    public static int minCost_memo(int[] cost, int idx, int[] dp){
        if(idx == cost.length){
            return dp[idx]=0;
        }

        if(dp[idx]!=0) return dp[idx];

        int oneStep = minCost_memo(cost,idx+1,dp);

        int twoStep = Integer.MAX_VALUE;
        if(idx + 2 <= cost.length){
            twoStep = minCost_memo(cost,idx+2,dp);
        }

        int ans = cost[idx] + Math.min(oneStep,twoStep);

        return dp[idx]=ans;
    }
    //Tabulation
    public static int minCost_tab(int[] cost, int[] dp){
        for(int idx = cost.length; idx>=0; idx--){
            if(idx == cost.length){
                dp[idx]=0;
                continue;
            }

            int oneStep = dp[idx+1]; //minCost_memo(cost,idx+1,dp);

            int twoStep = Integer.MAX_VALUE;
            if(idx + 2 <= cost.length){
                twoStep = dp[idx+2]; //minCost_memo(cost,idx+2,dp);
            }

            int ans = cost[idx] + Math.min(oneStep,twoStep);

            dp[idx]=ans;
        }
        return Math.min(dp[0],dp[1]);
    }

    //MOST OPTIMIZED
    public static int minCost_tab_mostOptimized(int[] cost){
        int n = cost.length;
        int idxp1 = cost[n-1];
        int idxp2 = 0;

        for(int idx = n-2; idx>=0; idx--){
            int ansIdx = cost[idx] + Math.min(idxp1,idxp2);

            idxp2 = idxp1;
            idxp1 = ansIdx;
        }
        return Math.min(idxp1,idxp2);
    }

}
