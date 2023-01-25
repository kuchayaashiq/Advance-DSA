package DynamicProgramming;

import java.util.Scanner;

public class Mx1Tiles {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long ans = tiles(n,m);
        System.out.println(ans);

        sc.close();

    }
    static int tiles(int n, int m){
        int[] dp = new int[n+1];
        if(n==m){
            return n;
        }
        for(int i = 1; i <= n; i++){
            if(i < m ){
                dp[i] = 1;
            }
            else if(i== m){
                dp[i] = 2;
            }
            else{
                dp[i] = (dp[i-1] + dp[i - m]);
                //dp[i] = (dp[i-1]%mod + dp[i-m]%mod)%mod;
            }
        }
        return dp[n];
    }
}
