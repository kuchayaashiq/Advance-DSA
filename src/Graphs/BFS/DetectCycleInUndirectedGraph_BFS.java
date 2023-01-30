package Graphs.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DetectCycleInUndirectedGraph_BFS {

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                if(bfs(0,-1, adj, vis))
                    return true;
            }
        }
        return false;
    }
    private static boolean bfs(int curr, int prev, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {


        Queue<Integer> que = new LinkedList<>();
        int[] parent = new int[adj.size()];
        que.add(curr);
        parent[curr]  =-1;
        //int level = 0;
        vis[curr] = true;
        while(!que.isEmpty()){
            int vtx = que.poll();
            for(int i = 0; i<adj.get(vtx).size(); i++){
                int nbr = adj.get(vtx).get(i);
                if(!vis[nbr]){

                    que.add(nbr);
                    parent[nbr] = vtx;
                    vis[nbr] = true;
                } else if (parent[vtx] != nbr) {
                    return true;
                }
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
