package basic;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean ans = checker(str);
        System.out.print(ans);

    }

    private static boolean checker(String str) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' || c == '[' || c =='{')
                st.push(c);
            else{
                if(st.isEmpty())
                    return false;
                char x = st.pop();
                if((c ==')' && x == '(') || (c ==']'&& x=='[') || (c =='}'&& x =='{')) {

                }
                else
                    return  false;
            }

        }
        if (st.isEmpty())
            return true;
        else
            return false;
    }
}
