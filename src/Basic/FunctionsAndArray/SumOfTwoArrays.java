package FunctionsAndArray;
/*
    Qyestion Link:
https://www.pepcoding.com/resources/online-java-foundation/function-and-arrays/sum-of-two-arrays-official/ojquestion
        1. You are given a number n1, representing the size of array a1.
        2. You are given n1 numbers, representing elements of array a1.
        3. You are given a number n2, representing the size of array a2.
        4. You are given n2 numbers, representing elements of array a2.
        5. The two arrays represent digits of two numbers.
        6. You are required to add the numbers represented by two arrays and print the
        arrays.
        Input Format
        A number n1
        n1 number of elements line separated
        A number n2
        n2 number of elements line separated
        Output Format
        A number representing sum of two numbers, represented by two arrays.
        Constraints
        1 <= n1, n2 <= 100
        0 <= a1[i], a2[i] < 10
        Sample Input
        5
        3 1 0 7 5
        6
        1 1 1 1 1 1
        Sample Output
        1	4	2	1	8	6
 */
import java.util.Scanner;

public class SumOfTwoArrays {
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

        int[] sum = new int[n > m?n:m];
        int i = n-1, j = m-1;
        int k = sum.length-1;
        int c =0;
        while(i >=0 || j >= 0){
            int d = c;
            if(i >= 0)
                d = d+ arr[i];
            if(j >= 0){
                d = d+ brr[j];
            }
            c = d /10;
            d = d % 10;
            sum[k] = d;
            i--;
            j--;
            k--;
        }
        for (i = 0; i < sum.length; i++) {
            System.out.print(sum[i]+"\t");
        }

    }
}
