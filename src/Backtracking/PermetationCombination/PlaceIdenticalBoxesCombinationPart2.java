package Backtracking.PermetationCombination;

import java.util.Scanner;

public class PlaceIdenticalBoxesCombinationPart2 {
    //ci - current index
    // ti - total boxes
    // lb - last box filled
    public static void combinations(boolean[] boxes, int ci, int ti, int lb){
        if(ci > ti){
            for(int i=0; i<boxes.length; i++){
                if(boxes[i]==true){
                    System.out.print("i");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }

        for(int i = lb +1; i<boxes.length; i++){
            if(boxes[i]==false){
                boxes[i]=true;
                combinations(boxes,ci+1,ti,i);
                boxes[i]=false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        combinations(new boolean[N], 1, R, -1);
    }
}
