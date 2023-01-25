package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack <Integer> mainSt = new Stack<>();
        Stack <Integer> maxSt = new Stack<>();
        maxSt.push(Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            int op =sc.nextInt();
            switch (op){
                case 1:
                    int item = sc.nextInt();
                    mainSt.push(i);
                    int max = maxSt.peek();
                    if (item > max)
                        maxSt.push(item);
                    else
                        maxSt.push(max);
                    break;
                case 2:
                    mainSt.pop();
                    maxSt.pop();
                    break;
                case 3:
                    System.out.println(maxSt.peek());
                    break;
            }

        }
    }
}
