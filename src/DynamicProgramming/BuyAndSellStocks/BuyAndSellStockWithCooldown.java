package DynamicProgramming.BuyAndSellStocks;

import java.util.Scanner;

public class BuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int dpi0 = 0;
        int dp_prev_to_prev = 0; // dp0[i-2];
        int dpi1 = -(int)(1e9);

        for(int i=0; i<n; i++){
            int dp_prev = dpi0; // dp0[i-1]

            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, dp_prev_to_prev - prices[i]);

            dp_prev_to_prev=dp_prev; //
        }

        return dpi0;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0 ; i < n ; ++i){
            prices[i] = sc.nextInt();
        }
        System.out.print(maxProfit(prices));
    }
}
