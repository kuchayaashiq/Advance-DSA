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
            //difference between two heights of two consecative buildings
            int diff = heights[i] - heights[i-1];
            // if this building is less or equal in heights
            // then move forward without using bricks or ladders
            if(diff <= 0)
                continue;
            // if this building has greater height than previous building
            // then use any one bricks or ladders to reach this height
            pq.add(diff);
            //we put only three differences in priority Queue
            if(pq.size()>ladders){
                // if size of pq is greater than ladders
                // remove minimum difference and subtract that from bricks
                // that means these bricks are used
                int min = pq.remove();
                bricks -= min;
            }
            //if bricks are less than 0 that means all bricks are used
            if (bricks<0)
                return i-1;

        }

        return heights.length-1;
    }
}
