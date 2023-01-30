package Graphs.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DFS_Implementation {
    public static void DFSTraversal(List<List<Integer>> edges, int n) {
        List<Integer> adjList[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adjList[u].add(v);
            adjList[v].add(u);
        }
        for (int i = 0; i < adjList.length; i++) {
            Collections.sort(adjList[i]);
        }
        dfs(0, adjList, new boolean[n]);
    }

    private static void dfs(int vtx, List<Integer>[] adjList, boolean[] vis) {
        vis[vtx] =true;
        System.out.print(vtx+" ");
        for(int i = 0; i<adjList[vtx].size(); i++){
            int nbr = adjList[vtx].get(i);
            if(!vis[nbr]){
               dfs(nbr, adjList, vis);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }
        DFSTraversal(ed, n);
    }
}
