package FunctionsAndArray;
/*
        1. You are given a number n1, representing the size of array a1.
        2. You are given n1 numbers, representing elements of array a1.
        3. You are given a number n2, representing the size of array a2.
        4. You are given n2 numbers, representing elements of array a2.
        5. The two arrays represent digits of two numbers.
        6. You are required to find the difference of two numbers represented by two arrays and print the arrays. a2 - a1

        Assumption - number represented by a2 is greater.
        Input Format
        A number n1
        n1 number of elements line separated
        A number n2
        n2 number of elements line separated
        Output Format
        A number representing difference of two numbers (a2 - a1), represented by two arrays.
        Constraints
        1 <= n1, n2 <= 100
        0 <= a1[i], a2[i] < 10
        number reresented by a1 is smaller than number represented by a2
        Sample Input
        3
        2 6 7
        4
        1 0 0 0
        Sample Output
        7 3 3
 */
import java.util.Scanner;

public class DifferenceOfTwoArrays {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] brr = new int[m];

        for (int i = 0; i < m; i++) {
            brr[i] = scn.nextInt();
        }
        int[] diff = new int[m];
        int i = n - 1;
        int j = m -1;
        int k = diff.length -1;
        int c =0;
        while(k >= 0){
            int d = 0;
            int n1v = i >= 0? arr[i]:0;
            if(brr[j] + c >= n1v){
                d = brr[j] + c - n1v;
                c = 0;
            }
            else{
                d = brr[j] + c + 10 - n1v;
                c = -1;
            }
            diff[k] = d;
            i--;
            j--;
            k--;
        }
        int idx = 0;
        while(idx < diff.length){
            if(diff[idx] == 0 )
                idx++;
            else
                break;
        }
        while(idx < diff.length){
            System.out.print(diff[idx] +" ");
            idx++;
        }
    }
}
