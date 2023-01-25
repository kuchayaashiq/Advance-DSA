package basic;

import java.util.Stack;

public class GenerateBinary {
    public static void main(String[] args) {
        int num = 1;
        calculate(num);
    }

    private static void calculate(int num) {
        Stack<Integer> st = new Stack<>();
        while (num >0){
            st.push(num%2);
            num /= 2;
        }
        while (!st.isEmpty())
            System.out.print(st.pop());
    }
}
