package basic;

import java.util.Arrays;
import java.util.Scanner;

public class example {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =7,k = 3;
        int a[] = new int[n];
        for (int i =0;i<n;i++){
            a[i] =sc.nextInt();
        }
        int count=0, sum=0;
        Arrays.sort(a);
        int i,j,l;
        for ( i = 0; i < n; i ++)
        {
            for ( j = i + 1; j < n; j++)
            {
                // use if statement to check duplicate element
                if ( a[i] == a[j])
                {
                    // delete the current position of the duplicate element
                    for ( l = j; l < n-1; l++)
                    {
                        a[l] = a [l + 1];
                    }
                    // decrease the size of array after removing duplicate element
                    n--;

                    // if the position of the elements is changes, don't increase the index j
                    j--;
                }
            }
        }


        for ( i =0;i<n;i++){
            for ( j =i+1;j<n;j++){
                if (a[i]!=a[j]) {
                   sum = a[i] + a[j];
                }
                if (sum%k == 0) {
                    count++;
                    //System.out.println(count);
                }
            }
        }
        for ( i =0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println(count);
    }
}
