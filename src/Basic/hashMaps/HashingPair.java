package hashMaps;

import java.util.HashMap;
import java.util.Scanner;

public class HashingPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++){
            if (!hm.containsKey(k-arr[i])) {
                System.out.println(1);
                return;
            }
            hm.put(arr[i], 1);
        }
        System.out.println(0);
    }
}
