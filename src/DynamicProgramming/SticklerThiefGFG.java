package DynamicProgramming;

import java.util.Scanner;

public class SticklerThiefGFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //Recursion Solution
        System.out.println("Recursive "+findMax(arr, 0));
        //Dp Memorization Solution
        int [] memo =  new int[n+1];
        System.out.println("Memo "+ findMax_memo(arr, 0, memo));
        //Dp Memorization Solution
        memo =  new int[n+1];
        System.out.println("Tabulation "+ findMax_Tabulation(arr, 0, memo));
    }
    //Dp Tabulation Solution
    private static int findMax_Tabulation(int[] arr, int idx, int[] memo) {
        for (idx = arr.length; idx >=0 ; idx--) {
            if(idx == arr.length){
                memo[idx] = 0;
                continue;
            }

            int rob = arr[idx];
            int notRob = 0;
            if(idx + 2 <= arr.length){
                rob +=  memo[idx +2 ];
            }
            notRob = memo[idx+1];

            memo[idx] =  Math.max(rob, notRob);
        }
        return memo[0];
    }

    //Dp Memorization Solution
    private static int findMax_memo(int[] arr, int idx, int[] memo) {
        if(idx == arr.length){
            return memo[idx] = 0;
        }
        if(memo[idx] != 0)
            return memo[idx];
        int rob = arr[idx];
        int notRob = 0;
        if(idx + 2 <= arr.length){
            rob += findMax_memo(arr,idx+2, memo);
        }
        notRob = findMax_memo(arr, idx+1, memo);

         return  memo[idx] =  Math.max(rob, notRob);
    }

    // Recursion Solution
    public static int findMax(int[] arr, int idx) {
        if(idx == arr.length){
            return 0;
        }
        int rob = arr[idx];
        int notRob = 0;
        if(idx + 2 <= arr.length){
            rob += findMax(arr,idx+2);
        }
        notRob = findMax(arr, idx+1);

        return Math.max(rob, notRob);
    }

}
