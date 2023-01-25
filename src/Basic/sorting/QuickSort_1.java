package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        int count =1, p =arr[0],j =0, l =0;

        for (int i = 1; i < n; i++) {
            if(arr[i] < p)
                left.add(arr[i]);
            else  if(arr[i] == p)
                count++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > p)
                right.add(arr[i]);
        }
        int[] result = new int[n];
        int k =0;
        for (int i = 0; i < left.size(); i++) {
            result[k++] = left.get(i);
        }
        for (int i = 0; i < count; i++) {
            result[k] = p;
            k++;
        }
        for (int i = 0; i < right.size(); i++) {
            result[k++] = right.get(i);
        }
        for (int i:result) {
            System.out.print(i+ " ");
        }

    }
}
