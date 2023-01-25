package FunctionsAndArray;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        reverseArray(arr);
        displayArray(arr);
        System.out.println();
        // Another way of displaying
        display(arr);
    }

    private static void reverseArray(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;

        }
    }

    private static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
    }
    // Another way of displaying
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }
}
