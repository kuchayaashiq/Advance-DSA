package basic;

import java.util.Scanner;

public class ArrayProductExceptSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] product =new int[n];
        for (int i = 0; i < n; i++) {
            product[i] = 1;
        }
        int k =0;
        for (int i = 0; i < n; i++) {
            int j =0;
            while (j<n){
                if(i!=j) {
                    product[k] = product[k] * arr[j];

                }

                j++;
            }
            k++;
            System.out.print(product[i] +" ");
        }

    }
}
