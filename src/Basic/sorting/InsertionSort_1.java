package sorting;

import java.util.Scanner;

public class InsertionSort_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        int num = arr[n-1];
//        for (int i = n-1; i >0 ; i--) {
//
//            if(arr[i-1] < num  ){
//                arr[i] = num;
//                //System.out.println();
//                for (int j = 0; j < n; j++) {
//                    System.out.print(arr[j]+ " ");
//
//                }
//                break;
//            }
//            else{
//                arr[i] = arr[i-1];
//                for (int j = 0; j < n; j++) {
//                    System.out.print(arr[j]+ " ");
//                }
//                System.out.println();
//            }
//        }


        for (int i = n-1; i >0 ; i--) {
            int num = arr[i];
            if(arr[i-1] > num  ) {
                arr[i] = arr[i - 1];
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[j]+" ");
                }
                System.out.println();
                arr[i - 1] = num;
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.print(arr[j]+" ");
        }

    }
}
