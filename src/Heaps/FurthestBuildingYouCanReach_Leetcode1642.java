package Heaps;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FurthestBuildingYouCanReach_Leetcode1642 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++){
            heights[i] = sc.nextInt();
        }
        int bricks = sc.nextInt();
        int ladders = sc.nextInt();
        System.out.println(furthestBuilding(heights,bricks, ladders));

    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++){
            int diff = heights[i] - heights[i-1];
            if(diff <= 0)
                continue;
            pq.add(diff);
            if(pq.size()>ladders){
                int min = pq.remove();
                bricks -= min;
            }
            if (bricks<0)
                return i-1;

        }
        return heights.length-1;
    }
}
