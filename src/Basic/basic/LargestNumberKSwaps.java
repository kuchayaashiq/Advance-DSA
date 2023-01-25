package basic;

import java.util.Scanner;

public class LargestNumberKSwaps {
    static String max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str = sc.next();
        max = str;
       largest(str, k);
       System.out.print(max);

    }
    private static void largest(String str, int k) {
       if(String.valueOf(str).compareTo(max) > 0){
            max = str;
       }
        if(k==0) {
            return;
        }
        for (int i = 0; i <str.length()-1; i++) {

            for (int j = i+1; j < str.length(); j++) {
                //swaps
                if(str.charAt(j) > str.charAt(i)){
                    str = SwapString(str,i , j);
                    largest(str,k-1);

                }

            }
        }

    }

    private static String SwapString(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);
        String left = str.substring(0, i);
        String middle = str.substring(i+1, j);
        String right = str.substring(j+1);

        return left + jth + middle + ith + right;
    }


}
