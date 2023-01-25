package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecker {
    public static void main(String[] args) {

        Scanner sc  =  new Scanner(System.in);
        String str = sc.next();


        boolean ans = CheckParenthesis(str);
        System.out.print(ans);
    }

    private static boolean CheckParenthesis(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else if (ch == ')') {
                boolean ans = handlingClosing(st, '(');
                if(ans == false)
                    return ans;
            }
            else if (ch == ']') {
                boolean ans = handlingClosing(st, '[');
                if(ans == false)
                    return ans;
            }
            else if (ch == '}') {
                boolean ans = handlingClosing(st, '{');
                if(ans == false)
                    return ans;
            }
        }
        if (st.empty())
            return true;
        else
            return false;
    }

    private static boolean handlingClosing(Stack<Character> st, char c) {
        if(st.empty())
            return false;
        else if (st.peek() != c) {
            return false;
        }
        else {
            st.pop();
            return true;
        }
    }
}
