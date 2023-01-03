package Backtracking.PermetationCombination;

import java.util.Scanner;

public class CoinPermutation {
    public static void getPermutations(int[] coins, int tar, int csum,boolean[] vis, String asf){
        if(csum > tar){
            return;
        }
        if(tar == csum){
            System.out.println(asf);
            return;
        }

        for(int j=0; j<coins.length; j++){
            if(vis[j]==false){
                vis[j] = true; // using this coin
                getPermutations(coins, tar, csum+coins[j], vis, asf+coins[j]+" ");
                vis[j] = false;
            }
        }
    }

    public static void coinChange(int[] coins, int amt){
        int n = coins.length;
        boolean[] vis = new boolean[n];

        getPermutations(coins,amt,0,vis,"");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        coinChange(coins, amt);
    }
}
