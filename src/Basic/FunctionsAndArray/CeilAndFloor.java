package FunctionsAndArray;
/*
        1. You are given a number n, representing the size of array a.
        2. You are given n numbers, representing elements of the array a.
        3. You are given another number d.
        4. You are required to find the ceil and floor of d in array a.
        Input Format
        A number n
        n1
        n2
        .. n number of elements
        A number d
        Output Format
        A number representing ceil
        A number representing floor
        Constraints
        1 <= n <= 1000
        -10^9 <= n1, n2, .. n elements <= 10^9
        -10^9 <= d <= 10^9
        Sample Input
        10
        1 5 10 15 22 33 40 42 55 66
        34
        Sample Output
        40
        33
 */
import java.util.Scanner;

public class CeilAndFloor {
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        // n =  size of array
        int n = scn.nextInt();
        int[] arr = new int[n];
        // Elements of Array
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();
        int low = 0;
        int high = n - 1;
        int ceil = 0, floor = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(data < arr[mid]){
                high = mid - 1;
                ceil = arr[mid];
            } else if (data > arr[mid]) {
                low = mid + 1;
                floor = arr[mid];
            }
            else {
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
        }
        System.out.println(ceil + "\n"+ floor);
    }
}
