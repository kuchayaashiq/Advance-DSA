package basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
INPUT is like this
n = 8. k =  1
arr = 1 2 2 3 4 4 5 5
output = 4
* */
public class DistinctPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[]  =  new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]  = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int no = arr[i];
            if (!map.containsKey(no)){
                map.put(no,1);
            }
            else {
                Integer freq = map.get(no);
                map.put(no,freq+1);
            }
        }
        int ans =0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()){
            int currkey = e.getKey();
            if(map.containsKey(currkey + k)){
                ans = ans+1;
            }
        }
        System.out.print(ans);
    }
}
