package searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Elements and Elements of Array");
        int n = sc.nextInt();
        int a[]= new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        System.out.println("Enter the Number want to search");
        int num= sc.nextInt();
        int low = 0;
        int high = n-1;
        int mid = (low+high)/2;
        while (low <= high && a[mid]!= num){

            if(a[mid]>num)
                high= mid-1;
            else
                low= mid+1;
            mid =(low+high)/2;
        }
        if(a[mid] == num)
            System.out.println(num + " is found at "+ mid+" location");
        else
            System.out.println(num + " is not found");

    }
}
