package basic;

import java.util.Scanner;

public class ArraySumUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int k =1;
        while(k<=cases){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i<n;i++){
                arr[i] = sc.nextInt();
            }
           int sum = ArraySum(arr,n);
            System.out.println("Case"+k+" : "+ sum);
            k++;
        }
    }

    private static int ArraySum(int[] arr, int n) {
        int sum =0;
        if(n<=0)
            return 0;
        return ArraySum(arr,n-1)+arr[n-1];
    }
}
