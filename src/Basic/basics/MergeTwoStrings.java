package basic;

import java.util.Scanner;

public class MergeTwoStrings {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str1.length() || i < str2.length(); i++) {
            if (i < str1.length())
                res.append(str1.charAt(i));
            if (i< str2.length())
                res.append(str2.charAt(i));
        }
        System.out.println(res);

    }
}
