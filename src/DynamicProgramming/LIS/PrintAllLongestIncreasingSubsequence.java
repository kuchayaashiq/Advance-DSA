package DynamicProgramming.LIS;

import java.util.ArrayDeque;
import java.util.Scanner;
class pair{
    int l;
    int i;
    int v;
    String psf;

    public pair(int l, int i, int v, String psf) {
        this.l = l;
        this.i = i;
        this.v = v;
        this.psf = psf;
    }
}

public class PrintAllLongestIncreasingSubsequence {
    public static void lengthOfLIS(int[] nums) {
        // Array to store longest length
        int[] dp =  new int[nums.length];
        int ans = 0;
        int omi = 0;
        for(int i = 0; i < nums.length; i++){
            // store 1 everytime because minimum subsequence length is 1
            dp[i] = 1;
            //loop to traverse backwards from i-1 to 0
            for (int j = i-1; j >=0 ; j--) {

                // check present element is greater than previous element
                //if it is Store the longest length from previous element
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }

            }
            if(dp[i] > ans){
                omi = i;
            }
            ans = Math.max(dp[i], ans);

        }
        System.out.println(ans);

        ArrayDeque<pair> queue = new ArrayDeque<>();
        queue.add(new pair(ans, omi, nums[omi], nums[omi]+ "" ));
        while (queue.size() > 0){
            pair rem = queue.removeFirst();
            if(rem.l == 1){
                System.out.println(rem.psf);
            }
            for (int j = rem.i-1; j >= 0 ; j--) {
                if(dp[j] == rem.l -1 && nums[j] < rem.v){
                    queue.add(new pair(dp[j],j, nums[j], nums[j]+ " "+ rem.psf ));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scc = new Scanner(System.in);
        int n = scc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scc.nextInt();
        // O(n^2) Solution
        lengthOfLIS(arr);

    }
}
