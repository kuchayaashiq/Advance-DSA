package sorting;

import java.util.ArrayList;
import java.util.Scanner;

/*  Print Sub-Arrays
In this challenge, print your array every time your partitioning method finishes,
      i.e. whenever two subarrays, along with the pivot, are merged together.

The first element in a sub-array should be used as a pivot.
Partition the left side before partitioning the right side.
The pivot should be placed between sub-arrays while merging them.
Array of length 1 or less will be considered sorted, and there is no need to sort or to print them.

Note
Please maintain the original order of the elements in the left and right partitions while partitioning around a pivot element.

For example: Partition about the first element for the array A[]={5, 8, 1, 3, 7, 9, 2} will be {1, 3, 2, 5, 8, 7, 9}
*
* */
public class QuickSort_2 {
    public static void main(String[] args) {
        Scanner sc  =  new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        QuickSort(arr);
    }

    private static void QuickSort(ArrayList<Integer> arr) {
        if(arr.size()<2)
            return;
        int pivot =arr.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i =1; i <arr.size(); i++) {
            if (arr.get(i)<= pivot) {
                left.add(arr.get(i));
            }
            else{
                right.add(arr.get(i));
            }
        }
        QuickSort(left);
        QuickSort(right);

        arr.clear();
        int  l =0;
        for (int i = 0; i < left.size(); i++) {
            arr.add(left.get(i));
            System.out.print(left.get(i)+ " ");
        }
        arr.add(pivot);
        System.out.print(pivot+ " ");

        for (int i = 0; i < right.size(); i++) {
            arr.add(right.get(i));
            System.out.print(right.get(i)+ " ");
        }
        System.out.println();



    }
}
