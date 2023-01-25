package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class NextSmallerRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ns[] = new int[n];
        Stack<Integer> st =  new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            while (!st.empty() && st.peek() >= arr[i]) {
                st.pop();
            }
            if (st.empty()) {
                ns[i] = -1;
            } else
                ns[i] = st.peek();
            st.push(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ns[i]+" ");
        }
    }
}
