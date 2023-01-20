package DynamicProgramming.BuyAndSellStocks;

import java.util.Scanner;

public class BuyAndSellStockInfiniteTransactionsAllowed {
    //  public int maxProfit(int[] prices) {
    //     int n = prices.length;

    //     int[] dp0 = new int[n];
    //     int[] dp1 = new int[n];

    //     for(int i=0; i<n; i++){
    //         if(i==0){
    //             dp0[i] = 0;
    //             dp1[i] = - prices[i];
    //             continue;
    //         }

    //         dp0[i] = Math.max(dp0[i-1],dp1[i-1]+prices[i]);
    //         dp1[i] = Math.max(dp1[i-1],dp0[i-1]-prices[i]);
    //     }

    //     return dp0[n-1];
    // }

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int dpi0 = 0;
        int dpi1 = -(int)(1e9);

        for(int i=0; i<n; i++){
            int dpi0_prev = dpi0;

            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, dpi0_prev - prices[i]);
        }

        return dpi0;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int  i = 0 ; i < n ; ++i){
            prices[i] = sc.nextInt();
        }
        System.out.print(maxProfit(prices));
    }
}
