package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class nextSmallerLeft {
    public static void main(String[] args) {

        Scanner sc  =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = solution(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    private static int[] solution(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        ans[0]= -1;

        for (int i = 1; i < arr.length; i++) {
            // for every element three operations are performed these are pop, print, push
            while (!st.empty()  && arr[i] <= st.peek()){
                st.pop();
            }
            if (st.empty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }


        return ans;
    }
}
