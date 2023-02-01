package basic;

import java.util.Scanner;

public class PeekElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int p = 0;
        for (int i = 0; p < n; i++) {
            p=i+1;
            if(arr[p] > arr[i]){
                System.out.println(arr[p]);
                break;
            }
            else
                System.out.println(-1);
        }
    }
}
