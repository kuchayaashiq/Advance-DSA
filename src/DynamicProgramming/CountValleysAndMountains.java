package DynamicProgramming;

import java.util.Scanner;
/*
        You are given a number n, representing the number of upstrokes / and number
        of down-strokes. You are required to find the number of valleys and mountains you can create using strokes.
         For eg:

        1 - /\

        2 - /\    or    /\/\
           /  \
                                                   /\
        3- /\/\   or    /\    or    /\    or    /\/  \    or    /\/\/\
          /    \       /  \        /  \/\
                      /    \
        NOTE: At no point should we go below the sea-level. (number of down-strokes
        should never be more than number of upstrokes).
        Input Format
        Input consists of an integer n
        Output Format
        Print a number representing the number of valleys and mountains you can create using strokes.
        Example 1
        Input
        4
        Output
        14
* */

public class CountValleysAndMountains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(count(sc.nextInt()));
        sc.close();
    }

    public static long count(int n) {
        // your code here
        long[] dp = new long[n+1];
        dp[0] =1;
        dp[1] = 1;
        for(int i =2; i < dp.length; i++){
            int inside =  i-1;
            int outside = 0;
            while(inside >=0){
                dp[i] += dp[inside] * dp[outside];
                inside--;
                outside++;
            }
        }
        return dp[n];
    }
}
