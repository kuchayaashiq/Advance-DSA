package basic;

import java.util.Scanner;

public class StringShuffle {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int[] indices = new int[str.length()];
        for(int i =0; i<str.length(); i++)
            indices[i] = sc.nextInt();
        StringBuilder result = new StringBuilder(str);
        for(int i =0; i<str.length(); i++)
            result.setCharAt(indices[i],str.charAt(i));
        result.toString();
        System.out.print(result);
    }
}
