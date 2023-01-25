package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterRight {
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
        st.push(arr[arr.length-1]);
        ans[arr.length-1]= -1;

        for (int i = arr.length-2; i >=0; i--) {
            // for every element three operations are performed these are pop, print, push
            while (st.size() > 0 && arr[i] >= st.peek()){
                st.pop();
            }
            if (st.size() == 0){
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
