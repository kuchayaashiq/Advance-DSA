package basic;


import java.util.Scanner;

public class SecondSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printSecondSmallest(arr,n);
    }

    private static void printSecondSmallest(int[] arr, int n) {
        int first,second;
        if(n<2)
            return;

        if(arr[0]< arr[1]){
            first = arr[0];
            second = arr[1];
        }
        else {
            first = arr[1];
            second = arr[0];
        }
        for (int i = 0; i < n ; i ++)
        {
            /* If current element is smaller than first
              then update both first and second */
            if (arr[i] < first)
            {
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and second
               then update second  */
            else if (arr[i] < second && arr[i] != first)
                second = arr[i];
        }
        if (second == first)
            System.out.println("There is no second smallest element");
        else
            System.out.println("The smallest element is " +
                    first + " and second Smallest" +
                    " element is " + second);
    }
}
