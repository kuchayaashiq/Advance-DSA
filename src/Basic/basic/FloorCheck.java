package basic;

import java.util.Scanner;

public class FloorCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++)
            arr[i]=sc.nextInt();

        int index = floorSearch(arr, n-1, f);
  //      System.out.println(ans);
        /*int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
        int n = arr.length;
        int f = 7;
        int index = floorSearch(arr, n - 1, f);*/
        if (index == -1)
            System.out.print(
                    "Floor of " + f
                            + " doesn't exist in array ");
        else
            System.out.print(
                    "Floor of " + f + " is "
                            + arr[index]);
    }
    static int floorSearch(int arr[], int n, int x)
    {
        // If last element is smaller than x
        if (x >= arr[n - 1])
            return n - 1;

        // If first element is greater than x
        if (x < arr[0])
            return -1;

        // Linearly search for the first element
        // greater than x
        for (int i = 1; i < n; i++)
            if (arr[i] > x)
                return (i - 1);

        return -1;
    }
}
