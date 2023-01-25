package sorting;

import java.util.Scanner;

public class MergeSortCountingInversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
       while(d>0){
           int n = sc.nextInt();
           int[] arr = new int[n];
           for (int i = 0; i < n; i++) {
               arr[i] = sc.nextInt();
           }
           int count = 0;
           for (int i = 0; i < n - 1; i++) {
               for (int j = i + 1; j < n; j++) {
                   if (arr[i] > arr[j])
                       count++;
               }
           }

           System.out.println(count);
           d--;
       }
    }
}