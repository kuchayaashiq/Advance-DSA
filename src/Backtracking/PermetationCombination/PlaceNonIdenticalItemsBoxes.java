package Backtracking.PermetationCombination;

import java.util.Scanner;

public class PlaceNonIdenticalItemsBoxes {

    public static void permutations(int[] boxes, int ci, int ti){
        // write your code here
        if(ci>ti){
            for (int j = 0; j < boxes.length; j++) {
                System.out.print(boxes[j]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < boxes.length; i++) {
            if(boxes[i] ==0){
                boxes[i] = ci;
                permutations(boxes,ci+1, ti);
                boxes[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        permutations(new int[N], 1, R);
    }
}
