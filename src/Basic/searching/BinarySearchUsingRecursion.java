package searching;

import java.util.Scanner;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Elements and Elements of Array");
        int n = sc.nextInt();
        int a[]= new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter the Number want to search");
        int num= sc.nextInt();
        int index = binarySearch(a,0,n-1,num);
        if (index == -1)
            System.out.println(num + " is not found");
        else
            System.out.println(num + " is found at "+ index+" location");
    }

    private static int binarySearch(int[] a, int low, int high, int num) {
        if(low <high){
            int mid = (low+high)/2;
            if (a[mid] == num)
                return mid;
            if (a[mid] > num)
                return binarySearch(a,low,mid-1, num);
            if (a[mid] < num)
                return binarySearch(a,mid+1,high,num);
        }
        return -1;
    }
}
