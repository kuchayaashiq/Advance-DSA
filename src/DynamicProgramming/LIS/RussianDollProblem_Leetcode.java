package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
*
*   Input :
     4
    16 9
    15 7
    13 20
    17 1
    Output:
    2
* */
public class RussianDollProblem_Leetcode {


    // russian doll envelopes ==================================================
    /*
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (t, o)->{
            return t[0] - o[0];
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        int ans=0;

        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

            ans=Math.max(ans,dp[i]);
        }

        return ans;
    }
    */

    // russian doll Better (O(NlogN)) ============
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (t, o)->{
            if(t[0] == o[0]){ // if width is equal then larger height should be on top
                return o[1] - t[1];
            }
            return t[0] - o[0];
        });

        int n = envelopes.length;
        ArrayList<Integer> dp = new ArrayList<>();

        for(int i=0; i<n; i++){
            int h = envelopes[i][1];

            int pos = findPos(dp, h);
            if(pos==dp.size()){
                dp.add(h);
            } else {
                dp.set(pos,h);
            }
        }

        return dp.size();
    }


    private static int findPos(ArrayList<Integer> dp, int ele) {
        int left = 0;
        int right = dp.size()-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(dp.get(mid) < ele){
                left = mid +1;
            }
            else {
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        System.out.println(maxEnvelopes(arr));
    }
}
