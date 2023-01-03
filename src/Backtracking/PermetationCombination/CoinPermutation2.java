package Backtracking.PermetationCombination;

import java.util.Scanner;

public class CoinPermutation2 {
    private static void getPermutations(int[] coins,int idx, int tar, int csum, String asf){
        if(csum>tar){
            return;
        }
        if(csum==tar){
            System.out.println(asf);
        }
        for (int j = 0; j < coins.length; j++) {
            getPermutations(coins, j, tar, csum+coins[j], asf+coins[j]+",");
        }
    }

    private static void coinChange2(int[] coins, int amt){

        getPermutations(coins,0, amt,0,"");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        coinChange2(coins, amt);
    }
}
