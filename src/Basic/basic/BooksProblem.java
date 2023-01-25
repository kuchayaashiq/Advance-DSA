package basic;

import java.util.Arrays;
import java.util.Scanner;

public class BooksProblem {
    public static int endindex;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int a[]= new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] prefix =  new int[n];
        int sum =0;
        for (int i = 0; i < n; i++) {

            sum += a[i];
            prefix[i] = sum;
        }
        int ans =0, starttime =0;
        for (int i = 0; i < n; i++) {
            int endtime = starttime- t;
            endindex = i-1;
            binarysearch(prefix,0,n-1,endtime);
            ans = Math.max(endindex,i+1);
            starttime = prefix[i];

        }
        System.out.print(ans);
    }

    private static void binarysearch(int[] prefix, int start , int end, int target) {
        if(start > end)
            return;
        int mid =  (start+end)/2;
        if(prefix[mid] <= target){
            endindex = mid;
            binarysearch(prefix,mid+1,end,target);

        }
        else{
            binarysearch(prefix,start,mid-1,target);
        }

    }
}
