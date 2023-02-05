package Graphs.DFS;

import java.util.ArrayList;
import java.util.Scanner;
/*
    Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it
    contains any cycle or not.
    Input Format:
    First line contains two integers denoting V and E respectively.
    Next E lines contain two integers u and v in each line, denoting an edge from u to v.
    Output Format
    Return true if there is a cycle in the graph, else return false.
    Example 1
    Input
    4 6
    0 1
    0 2
    1 2
    2 0
    2 3
    3 3
    Output
    True
* */
public class DetectCycleInDirectedGraph {

    public static boolean isCyclic(int V, ArrayList<Integer>[] adj) {
        
        boolean[] visited = new boolean[V];
        boolean [] stack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if(dfs(i, adj, visited, stack)){
                    return  true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int curr, ArrayList<Integer>[] adj, boolean[] visited, boolean[] stack) {

        //Mark curr node as true
        //Put this node into recursion stack
        //check all neighbours
        //remove the curr node from recursion stack
        visited[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < adj[curr].size(); i++) {
            int nbr = adj[curr].get(i);
            if(!visited[nbr]){
                if(dfs(nbr, adj, visited, stack)){
                    return true;
                }
            }else if (stack[nbr]) {  // this confirms the stack
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        boolean ans = isCyclic(V, adj);
        if (ans) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
