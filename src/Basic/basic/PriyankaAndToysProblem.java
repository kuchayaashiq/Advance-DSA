package basic;

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaAndToysProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int c=1;
        int s= arr[0];
        for (int i = 0; i < n; i++) {
            if(arr[i]>s+4){
                c+=1;
                s=arr[i];
            }
        }
        System.out.println(c);
    }
}
