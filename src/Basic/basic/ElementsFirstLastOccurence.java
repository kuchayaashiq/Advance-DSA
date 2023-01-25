package basic;

import java.util.Scanner;

public class ElementsFirstLastOccurence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =  new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int data = sc.nextInt();
        int low = 0;
         int high = n-1;
         int fi = -1;
         while (low <= high){
             int mid  = (low+ high)/2;
             if(data < arr[mid]){
                 high = mid-1;
             } else if (data > arr[mid]) {
                 low = mid+1;
             }
             else {
                 fi = mid;
                 high = mid-1;
             }
         }
        System.out.print(fi);


        low = 0;
        high = n-1;
        int li = -1;
        while (low <= high){
            int mid  = (low+ high)/2;
            if(data < arr[mid]){
                high = mid-1;
            } else if (data > arr[mid]) {
                low = mid+1;
            }
            else {
                li = mid;
                low = mid+1;
            }
        }
        System.out.print(" "+ li);

    }
}
