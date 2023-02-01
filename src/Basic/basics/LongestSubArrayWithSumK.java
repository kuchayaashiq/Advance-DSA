package basic;

import java.util.Scanner;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum =0;
        int max =0;
        int i =0, j =0;
            while (j<n){
                sum = sum+arr[j];
                if(sum < k)
                    j++;
                else if( sum == k) {
                    max = Math.max(max,(j - i + 1) );
                    j++;
                }
                else{
                    while (sum > k) {
                        sum = sum - arr[i];
                        i++;
                    }
                    j++;
                }

        }
        System.out.println(max);
    }
}
