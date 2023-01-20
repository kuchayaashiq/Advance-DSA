package DynamicProgramming.BuyAndSellStocks;

import java.util.Scanner;

public class BuyAndSellStockWithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int dpi0 = 0;
        int dpi1 = -(int)(1e9);

        for(int i=0; i<n; i++){
            int dpi0_prev = dpi0;

            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, dpi0_prev - (prices[i]+fee));
        }

        return dpi0;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        int k = sc.nextInt();
        for(int i = 0 ; i < n ; ++i){
            prices[i] = sc.nextInt();
        }
        System.out.print(maxProfit(prices,k));
    }
}
