package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle_Histogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ns = NextSmaller(arr);
        int[] ps = PreviousSmaller(arr);

        int maxarea = 0;
        for (int i = 0; i < ns.length; i++) {
            int width =  ns[i]-ps[i] -1;
            int area  = arr[i]* width;
            maxarea = Math.max(maxarea,area);
        }
        System.out.println(maxarea);
    }
    private static int[] NextSmaller(int[] arr) {
        int[] ns = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        ns[arr.length-1] = arr.length;
        for (int i = arr.length-2; i >=0 ; i--) {
            while (!st.empty() && arr[i] <= arr[st.peek()])
                st.pop();
            if(st.empty())
                ns[i] = arr.length;
            else
                ns[i] = st.peek();
            st.push(i);
        }

        return ns;
    }
    private static int[] PreviousSmaller(int[] arr) {
        int[] ps = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ps[0] = -1;
        for (int i = 1; i < arr.length ; i++) {
            while (!st.empty() && arr[i] <= arr[st.peek()])
                st.pop();
            if (st.empty())
                ps[i] = -1;
            else
                ps[i] = st.peek();
            st.push(i);
        }
        return ps;
    }


}
