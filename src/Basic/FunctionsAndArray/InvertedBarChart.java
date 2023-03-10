package FunctionsAndArray;

import java.util.Scanner;

public class InvertedBarChart {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        for (int floor = 1; floor <= max; floor++) {
            for (int i = 0; i < n; i++) {
                if (arr[i] >= floor)
                    System.out.print("*\t");
                else
                    System.out.print("\t");

            }
            System.out.println();
        }
    }
}
