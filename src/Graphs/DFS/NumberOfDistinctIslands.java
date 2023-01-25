package Graphs.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfDistinctIslands {
    static ArrayList<Integer> islandSizes = new ArrayList<>();
    static  int size = 0;
    public static void dfs(int i, int j, int[][] grid){
        grid[i][j] = 0; // changing land to water

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] dir:dirs){
            int x = i+dir[0];
            int y =j + dir[1];

            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
                size++;
                dfs(x,y,grid);
            }
        }
    }


    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid);
                    if(!islandSizes.contains(size)){
                        islandSizes.add(size);
                        count++;
                        size = 0;
                    }
                }
            }
        }

        return islandSizes.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = countDistinctIslands(grid);
        System.out.println(ans);
    }
}
