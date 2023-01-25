package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean ans = isValidStr(str);
        System.out.println(ans);
    }

    private static boolean isValidStr(String str) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(')
                open.push(i);
            else if (c == '*') {
                star.push(i);
            }
            else {
                if (!open.empty())
                    open.pop();
                else if (!star.empty()) {
                    star.pop();
                }
                else
                    return false;
            }
        }
        while (!open.empty()){
            if(star.empty())
                return false;
            else if (open.peek() < star.peek()) {
                open.pop();
                star.pop();
            }
            else
                return false;
        }
        return true;
    }
}
