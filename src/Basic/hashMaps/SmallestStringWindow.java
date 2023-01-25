package hashMaps;

import java.util.HashMap;
import java.util.Scanner;

public class SmallestStringWindow {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc =  new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String ans = smallestString(str1, str2);
        System.out.println(ans);
    }

    private static String smallestString(String str1, String str2) {
        String res ="";
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            hm2.put(ch, hm2.getOrDefault(ch,0) + 1);
        }

        int mct = 0;                    // match count
        int dmct = str2.length();    // desired match count
        HashMap<Character, Integer> hm1 = new HashMap<>();
        int i = -1, j = -1 ;
         while (true){
             boolean f1 = false;
             boolean f2 = false;

             // acquiire

             while (i < str1.length()-1 && mct < dmct){
                 i++;
                 char ch = str1.charAt(i);
                 hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
                 if(hm1.getOrDefault(ch, 0) <= hm2.getOrDefault(ch, 0)){
                     mct++;
                 }
                 f1 = true;
             }

             //collect Answer and Release

                while (j < i && mct == dmct){
                    String pans = str1.substring(j+1, i+1);
                    if( res.length() == 0 || pans.length() <res.length()){
                        res = pans;
                    }
                    j++;
                    char ch = str1.charAt(j);
                    if(hm1.get(ch) == 1){
                        hm1.remove(ch);

                    }
                    else {
                        hm1.put(ch, hm1.get(ch) - 1);
                    }
                    if(hm1.getOrDefault(ch, 0) < hm2.getOrDefault(ch,0)){
                        mct--;
                    }
                    f2 = true;
                }
                if (f1 == false && f2 == false){
                    break;
                }
         }
        return res;
    }
}
