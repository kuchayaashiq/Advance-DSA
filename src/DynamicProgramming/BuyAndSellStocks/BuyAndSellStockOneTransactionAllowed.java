package DynamicProgramming.BuyAndSellStocks;

import java.util.Scanner;
    /*You are given an array of stock prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different
    day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
    return 0.
    Note: You just need to complete maxProfit() function and return the maximum profit you can achieve
    satisfying the above conditions.
    Input Format
    The first line contains a single integer n denoting the size of the array prices. Next line contains
    n spaced integers representing the elements of prices array.
    Output Format
    Print maximum profit that you can achieve.
    Example 1
    Input
    6
    8 2 6 4 7 5
    Output
    5
*/
public class BuyAndSellStockOneTransactionAllowed {
    //  public static int maxProfit(int[] prices) {
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
    //         dp1[i] = Math.max(dp1[i-1],0-prices[i]);
    //     }

    //     return dp0[n-1];
    // }

    // buy and sell stocks 1 (leetcode 121) BETTER ===================================================
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int dpi0 = 0;
        int dpi1 = -(int)(1e9);

        for(int i=0; i<n; i++){
            // dp0[i] = Math.max(dp0[i-1],dp1[i-1]+prices[i]);
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            // dp1[i] = Math.max(dp1[i-1],0-prices[i]);
            dpi1 = Math.max(dpi1, 0-prices[i]);
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
