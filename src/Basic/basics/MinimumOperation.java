
package basic;

import java.util.Scanner;
public class MinimumOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        int counter = 0;
        for (int i = 0; i < n; i++) {
            while (arr2[i]>arr1[i]){
                if(arr2[i]%2!=0){
                    arr2[i ]= arr2[i]+1;
                    counter++;
                }
                arr2[i] = arr2[i]/2;
            }
            while(arr2[i]<arr1[i]){
                arr2[i] = arr2[i]+1;
                counter++;
            }
        }
        System.out.println("result: " + counter);
    }
}
