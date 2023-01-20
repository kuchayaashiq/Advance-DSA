package DynamicProgramming.BuyAndSellStocks;

import java.util.Scanner;

public class BuyAndSellStocksK_TransactionsAllowed {
    public static int maxProfit(int K, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][K+1][2];

        for(int i=0; i<n; i++){
            for(int k=0; k<=K; k++){
                for(int x=0; x<2; x++){
                    if(k==0){
                        if(x==0){
                            dp[i][k][x]=0;
                        } else {
                            dp[i][k][x]=(int)(-1e9);
                        }
                    } else{
                        if(i==0){
                            if(x==0){
                                dp[i][k][x] = Math.max(0, (int)(-1e9) + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max((int)(-1e9), 0 -prices[i]);
                            }
                        } else {
                            if(x==0){
                                dp[i][k][x] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] -prices[i]);
                            }
                        }
                    }
                }
            }
        }

        return dp[n-1][K][0];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        int k = sc.nextInt();
        for(int i = 0 ; i < n ; ++i){
            prices[i] = sc.nextInt();
        }
        System.out.print(maxProfit(k,prices));
    }
}
