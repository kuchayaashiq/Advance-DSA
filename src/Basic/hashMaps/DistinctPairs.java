package hashMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DistinctPairs {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr =  new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> hm =new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],1 );
            }
            else {
                hm.put(arr[i],hm.get(arr[i])+1);
            }
        }
        int count = 0;
        for(int i :hm.keySet()){
            int a= i+k;
            if(k >0 && hm.containsKey(a))
                count++;
            else if (k==0 && hm.get(i) >1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
