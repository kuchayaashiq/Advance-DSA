package hashMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvenOddProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str  = sc.next();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!hm.containsKey(ch)){
                hm.put(ch, 1);
            }
            else {
                hm.put(ch, hm.get(ch)+1);
            }
        }
        int countX =0, countY= 0;
        for(Map.Entry<Character, Integer> e : hm.entrySet()){
            int num = (int)e.getKey();
            if(num%2 == 0 && e.getValue()%2 ==0){
                countX +=1;
            }
            if(num%2 !=0 && e.getValue()%2 !=0)
                countY +=1;
        }
        int count = countX +countY;
        if(count %2 ==0)
            System.out.println("EVEN");
        else
            System.out.println("ODD");
    }

}
