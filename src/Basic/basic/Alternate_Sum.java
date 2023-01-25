package basic;

import java.util.Scanner;

public class Alternate_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int sum1= 0, sum2 =0;
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(count%2 ==0){
                    sum1 +=arr[i][j];
                }
                else
                    sum2+=arr[i][j];
                count++;
            }
        }
        System.out.println(sum1+" "+sum2);

    }
}
