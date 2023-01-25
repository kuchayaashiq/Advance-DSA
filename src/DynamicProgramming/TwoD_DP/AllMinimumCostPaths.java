package DynamicProgramming.TwoD_DP;

import java.util.ArrayDeque;
import java.util.Scanner;

public class AllMinimumCostPaths {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        //Write code here
        int[][] dp = new int[n][m];
        int minCost = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (i == arr.length - 1 && j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j];
                    continue;
                }
                int right = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;

                if (j + 1 < arr[0].length) {
                    right = dp[i][j + 1];//minPath_memo(arr, i, j+1, dp);
                }
                if (i + 1 < arr.length) {
                    down = dp[i + 1][j];  //minPath_memo(arr, i+1, j, dp);
                }
                int ans = arr[i][j] + Math.min(right, down);

                dp[i][j] = ans;
            }
        }
        System.out.println(dp[0][0]);
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair("", 0, 0));
        while(queue.size() > 0){
            Pair rem = queue.removeFirst();

            if(rem.i == dp.length - 1 && rem.j == dp[0].length - 1){
                System.out.println(rem.psf);
            } else if(rem.i == dp.length - 1){
                queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
            } else if(rem.j == dp[0].length - 1){
                queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
            } else {
                if(dp[rem.i][rem.j + 1] < dp[rem.i + 1][rem.j]){
                    queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
                } else if(dp[rem.i][rem.j + 1] > dp[rem.i + 1][rem.j]){
                    queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
                } else {
                    queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
                    queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
                }
            }
        }

    }
}
