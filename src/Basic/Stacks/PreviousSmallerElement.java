package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ps[] = new int[n];
        Stack<Integer> st =  new Stack<>();
        for (int i = 0; i <n ; i++) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.empty()) {
                ps[i] = -1;
            } else
                ps[i] = st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ps[i]+" ");
        }
    }
}
