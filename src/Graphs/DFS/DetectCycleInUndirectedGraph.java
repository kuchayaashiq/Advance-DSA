package Graphs.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleInUndirectedGraph {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                if(dfs(0,-1, adj, vis))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(int curr, int prev, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            int nbr = adj.get(curr).get(i);
            if(!vis[nbr]){
                if(dfs(nbr,curr, adj, vis))
                    return true;
            } else if (vis[nbr] && nbr != prev) {
                return true;

            }
        }

        return false;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
