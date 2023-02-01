package basic;

import java.util.Scanner;

public class minCutTrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[]= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long min =0, max =0;
        // Find Maximum height of tree in an array
        for (int i = 0; i < n; i++) {
            max =Math.max(arr[i],max);
        }
        long ans =-1;
        while (min<= max){
            long mid =(min+max)/2;
            int value = isAllowed(mid, arr,k);
            if (value == 0){
               min = mid+1;
            }
            else {
                ans =mid;
                max =mid-1;
            }
        }
        System.out.println(ans);

    }

    private static int isAllowed(long x, int[] arr, int k) {
        long wood =0;
        for (int i = 0; i < arr.length; i++) {
            int currwood =arr[i]-(int) x;
            if(currwood>0)
                wood = wood+currwood;
        }
        if (wood<=k)
            return 1;
        else
            return 0;
    }
}
