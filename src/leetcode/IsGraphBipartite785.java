package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class IsGraphBipartite785 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i =0; i < graph.length;i++){
            if(color[i] == -1){
                if(!dfs(i, color, graph))
                    return false;
            }
        }
        return true;
    }
    private boolean dfs(int curr, int[] color, int[][] graph){
        for(int i =0; i < graph[curr].length;i++){
            int nbr = graph[curr][i];
            if(color[nbr] == -1){
                color[nbr] = 1-color[curr];
                if(!dfs(nbr, color, graph))
                    return false;
            }else if(color[nbr] == color[curr]){
                return false;
            }
        }
        return true;
    }
}
