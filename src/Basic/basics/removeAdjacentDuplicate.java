package basic;

import java.util.Scanner;

public class removeAdjacentDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(remove(str));

    }

    static String remove(String str){
        char last = '\0';
        return removeAdjacent(str, last);
    }

    private static String removeAdjacent(String str, char last) {
        if(str.length() <=1)
            return str;
        if(str.charAt(0)==str.charAt(1)){
            last= str.charAt(0);

            while(str.length() >1 && str.charAt(0)==str.charAt(1))
                str = str.substring(1,str.length());
                str = str.substring(1,str.length());
            return removeAdjacent(str,last);
        }
        String remStr =removeAdjacent(str.substring(1, str.length()), last);

        if(remStr.length() != 0 && remStr.charAt(0) == str.charAt(0)){
            last = str.charAt(0);
            return remStr.substring(1,remStr.length());
        }
        if(remStr.length() == 0 && last == str.charAt(0))
            return remStr;

        return (str.charAt(0) + remStr);
    }
}
