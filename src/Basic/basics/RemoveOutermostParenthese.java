package basic;

import java.util.Scanner;

public class RemoveOutermostParenthese {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder s = new StringBuilder();
        int opened =0;
        for (char c: str.toCharArray()){
            if(c =='('){
                if(opened > 0)
                    s.append(c);
                opened++;

            }
            else{
                if (opened>1)
                    s.append(c);
                opened--;
            }
        }
        System.out.println((s.toString()));
    }
}
