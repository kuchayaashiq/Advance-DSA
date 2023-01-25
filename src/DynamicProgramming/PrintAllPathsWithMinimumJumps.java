package DynamicProgramming;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
 class Pair{
    int idx;
    String asf;
    int jmps;
    Pair(int idx,String asf,int jmps){
        this.idx = idx;
        this.asf = asf;
        this.jmps = jmps;
    }
}

public class PrintAllPathsWithMinimumJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        PrintAllPaths(arr);

    }
    private static void PrintAllPaths(int[] arr) {
        int  [] dp = new int[arr.length + 1];
        for(int idx = arr.length-2 ; idx >=0 ; idx--) {
            int steps = arr[idx];

            int min = Integer.MAX_VALUE;
            if (steps > 0) {
                for (int i = 1; i <= steps; i++) {
                    if (idx + i < arr.length)
                        min = Math.min(min, dp[idx + i]);
                }

            }
            dp[idx] = min == Integer.MAX_VALUE ? min : min + 1;
        }
        System.out.println(dp[0]);

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0 , ""+ 0 , dp[0]));

        while(queue.size() > 0){
            Pair rem = queue.remove();

            if(rem.jmps == 0){
                System.out.println(rem.asf+" .");
                continue;
            }

            for(int step = 1 ; step <= arr[rem.idx] ; step++){
                if(rem.idx+step < arr.length && rem.jmps-1 == dp[rem.idx+step]){
                    queue.add(new Pair(rem.idx+step, rem.asf +" -> " + (rem.idx+step), rem.jmps-1));
                }
            }
        }
    }
}
