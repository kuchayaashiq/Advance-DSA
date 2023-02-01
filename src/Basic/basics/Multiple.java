package basic;

import java.util.Scanner;

public class Multiple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            int count =0;
            for (int j = 0; j < n; j++) {
                if(i != j){
                    if(arr[j]%arr[i] == 0)
                        count++;
                }
            }
            counts[i] =count;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(counts[i]+" ");
        }
    }
}
