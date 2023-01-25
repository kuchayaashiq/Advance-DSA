package DynamicProgramming.LIS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
* Input:
*   3
    50 45 20
    95 37 53
    45 23 12
    Output
     190
* */

public class BoxStackingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cuboids = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                cuboids[i][j] = sc.nextInt();
            }
        }
       System.out.println(maxHeight(cuboids));
        //Sort the dimensions for every cuboid
        // Sort all cuboids on the basis of width
    }
    public static int maxHeight(int[][] cuboids) {
        for (int i = 0; i < cuboids.length; i++)
            Arrays.sort(cuboids[i]);

        Arrays.sort(cuboids, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return b[0] - a[0];
                if (a[1] != b[1])
                    return b[1] - a[1];
                return b[2] - a[2];
            }
        });
        return LIS(cuboids);
    }
    public static int LIS(int[][] cuboids){
        int[] dp =  new int[cuboids.length];
        int ans = 0;
        for (int j = 0; j < cuboids.length; ++j) {
            dp[j] = cuboids[j][2];
            for (int i = 0; i < j; ++i) {
                if (cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]) {
                    dp[j] = Math.max(dp[j], dp[i] + cuboids[j][2]);
                }
            }
            ans = Math.max(ans, dp[j]);
        }
        return ans;
    }
}
