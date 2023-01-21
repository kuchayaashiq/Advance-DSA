package DynamicProgramming.TwoD_DP;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumGoldPath {
    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mine[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                mine[i][j]=sc.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        for(int j = mine[0].length-1; j>=0; j--){
            for(int i=0; i<mine.length; i++){
                if(j==mine[0].length-1){
                    dp[i][j] = mine[i][j];
                    continue;
                }

                int up = 0;
                int same = 0;
                int down = 0;

                if(i-1 >= 0){
                    up = dp[i-1][j+1]; //getMax_memo(mine, i-1, j+1,dp);
                }

                same = dp[i][j+1];//getMax_memo(mine, i, j+1,dp);

                if(i+1<mine.length){
                    down = dp[i+1][j+1]; //getMax_memo(mine, i+1, j+1,dp);
                }

                int ans = mine[i][j] + Math.max(up,Math.max(same,down));

                dp[i][j] = ans;
            }
        }

        int ans = 0;
        for(int i=0; i<mine.length; i++){
            ans = Math.max(ans,dp[i][0]);
        }

        System.out.println(ans);

        ArrayDeque<Pair> dq = new ArrayDeque<>();
        for(int i=0; i<mine.length; i++){
            if(dp[i][0] == ans){
                dq.add(new Pair(i+" ",i, 0));
            }
        }
        while(dq.size() > 0){
            Pair rem  =  dq.removeFirst();
            if(rem.j == mine[0].length-1){
                System.out.println(rem.psf);
            }
            else if(rem.i == 0){
                int g = Math.max(dp[rem.i][rem.j +1], dp[rem.i+1][rem.j +1]);
                if(g ==  dp[rem.i][rem.j +1]){
                    dq.add(new Pair(rem.psf + "d2 ", rem.i, rem.j+1));
                }
                if(g ==  dp[rem.i+1][rem.j +1]){
                    dq.add(new Pair(rem.psf + "d3 ", rem.i+1, rem.j+1));
                }
            }
            else if(rem.i == mine.length-1){
                int g = Math.max(dp[rem.i][rem.j +1], dp[rem.i-1][rem.j +1]);
                if(g ==  dp[rem.i][rem.j +1]){
                    dq.add(new Pair(rem.psf + "d2 ", rem.i, rem.j+1));
                }
                if(g ==  dp[rem.i-1][rem.j +1]){
                    dq.add(new Pair(rem.psf + "d1 ", rem.i-1, rem.j+1));
                }
            }
            else{
                int g = Math.max(dp[rem.i][rem.j +1],
                        Math.max(dp[rem.i -1][rem.j +1], dp[rem.i+1][rem.j +1]));
                if(g ==  dp[rem.i][rem.j +1]){
                    dq.add(new Pair(rem.psf + "d2 ", rem.i, rem.j+1));
                }
                if(g ==  dp[rem.i-1][rem.j +1]){
                    dq.add(new Pair(rem.psf + "d1 ", rem.i-1, rem.j+1));
                }
                if(g ==  dp[rem.i+1][rem.j +1]){
                    dq.add(new Pair(rem.psf + "d3 ", rem.i+1, rem.j+1));
                }
            }
        }
    }
}
