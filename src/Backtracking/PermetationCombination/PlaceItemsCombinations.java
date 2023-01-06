package Backtracking.PermetationCombination;

import java.util.Scanner;

public class PlaceItemsCombinations {
    // cb -current box
    // tb - total boxes
    //itpsf - items placed so far
    // ts- total items
    //asf - answer so far
    public static void combinations(int cb, int tb, int itpsf, int ts, String asf){
        // write your code here
        if(cb>tb){
            if(itpsf == ts){
                System.out.println(asf);
            }
            return;
        }
        //include
        combinations(cb+1,tb,itpsf +1,ts,asf+"i");
        //not Include
        combinations(cb+1,tb,itpsf,ts,asf+"-");

    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        combinations(1, N, 0, R, "");
    }
}
