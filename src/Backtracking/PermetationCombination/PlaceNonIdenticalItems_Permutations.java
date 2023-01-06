package Backtracking.PermetationCombination;

import java.util.Scanner;

public class PlaceNonIdenticalItems_Permutations {
    // CB- current box
    // TB - total box
    // ritems- total no of items
    // itpsf - items placed so far
    // ts - total items
    // asf - answer so far
    public static void permutations(int cb, int tb, boolean[] items, int itpsf, int ts, String asf){
        if(cb > tb){
            if(itpsf == ts){
                System.out.println(asf);
            }
            return;
        }
        // i can pick any of the remaining items
        for(int i=0; i<items.length; i++){
            if(items[i]==false){ // we have not placed current item (ith item)
                items[i] = true;
                permutations(cb+1,tb,items,itpsf+1,ts,asf+(i+1));
                items[i] = false;
            }
        }
        // keep the current box empty
        permutations(cb+1,tb,items,itpsf,ts,asf+"0");
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        permutations(1, N, new boolean[R], 0, R, "");
    }
}
