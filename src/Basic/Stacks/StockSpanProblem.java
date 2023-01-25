package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> st = new Stack<>();
        int span[] = new int[arr.length];
        st.push(0);
        span[0] = 1;
        for (int i = 1; i <n ; i++) {
            while (!st.empty() &&arr[i]>= arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty())
                span[i] = i+1;
            else
                span[i] = i - st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(span[i] +" ");
        }
    }
}
