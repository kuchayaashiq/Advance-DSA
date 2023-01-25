package basic;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class k_Anagram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str1 = sc.next();
        String str2 = sc.next();
        boolean ans  = isK_Anagram(str1,str2,k);
        if(ans == true)
            System.out.println(str1+" and "+ str2 + " are K_Anagrams ");
        else
            System.out.println(str1+" and "+ str2 + " are not K_Anagrams ");
    }

    private static boolean isK_Anagram(String str1, String str2, int k) {
        if(str1.length()!=str2.length())
            return false;
        int map[]= new int[str1.length()] ;
        char[] charstr1 = str1.toCharArray();
        Arrays.sort(charstr1);
        char[] charstr2 = str2.toCharArray();
        Arrays.sort(charstr2);
        for(int i=0;i<str1.length();i++) {
            map[charstr1[i]]++;
        }
        int count=0 ;
        for(int i=0;i<str2.length();i++)
        {
            if(map[charstr2[i]]==0)
                count++ ;
            else
                map[charstr2[i]]-- ;
        }
        if(count<=k)
            return true ;

        return  false;
    }
}
