package DynamicProgramming.TwoD_DP;

import java.util.Scanner;

/*\
*
     4 4
     1 3 1 5
     2 2 4 1
     5 0 2 3
     0 6 1 2
     *
     * */
public class GoldMineProblemGFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mine = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mine[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxGold(n, m, mine));
    }
    static int maxGold(int n, int m, int[][] mine) {
        // code here
        // int ans = 0;
        int[][] dp = new int[n][m];
        // for(int i=0; i<n; i++){
        //     int gold = getMax_rec(M,i,0);
        //     ans = Math.max(gold,ans);
        // }

        // for(int i=0; i<n; i++){
        //     int gold = getMax_memo(M,i,0,dp);
        //     ans = Math.max(gold,ans);
        // }

        // return ans;

        return goldmine_tab(mine, dp);
    }
    //TABULATION
    public static int goldmine_tab(int[][] mine, int[][] dp){
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

        return ans;
    }
    //USING MEMORIZATION
    public static int getMax_memo(int[][] mine, int i, int j, int[][] dp) {
        if (j == mine[0].length - 1) {
            return dp[i][j] = mine[i][j];
        }
        if (dp[i][j] != 0) return dp[i][j];

        int up = 0;
        int same = 0;
        int down = 0;

        if (i - 1 >= 0) {
            up = getMax_memo(mine, i - 1, j + 1, dp);
        }

        same = getMax_memo(mine, i, j + 1, dp);

        if (i + 1 < mine.length) {
            down = getMax_memo(mine, i + 1, j + 1, dp);
        }

        int ans = mine[i][j] + Math.max(up, Math.max(same, down));

        return dp[i][j] = ans;
    }
    //Using recursion
    public static int getMax_rec(int[][] mine, int i, int j){
        if(j==mine[0].length-1){
            return mine[i][j];
        }
        int up = 0;
        int same = 0;
        int down = 0;
        if(i-1 >= 0){
            up = getMax_rec(mine, i-1, j+1);
        }

        same = getMax_rec(mine, i, j+1);

        if(i+1<mine.length){
            down = getMax_rec(mine, i+1, j+1);
        }
        int ans = mine[i][j] + Math.max(up,Math.max(same,down));
        return ans;
    }



}
