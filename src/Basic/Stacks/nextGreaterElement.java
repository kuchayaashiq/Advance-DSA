package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class nextGreaterElement {
    public static void main(String[] args) {
        Stack <Integer> stack = new Stack<>();
        Scanner sc  =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int i;

        //0th index will be pushed to stack
        stack.push(0);

        int[] ans = new int[n];

        for(i=1;i<n;i++){

            //boolean result=  stack.empty();

            while((!stack.empty())&&(arr[stack.peek()]<arr[i])){

                ans[stack.peek()] = arr[i];
                stack.pop();
                //result = stack.empty();
            }
            stack.push(i);
        }

        while(stack.empty()==false){
            ans[stack.peek()] = -1;
            stack.pop();
        }

        for(i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
