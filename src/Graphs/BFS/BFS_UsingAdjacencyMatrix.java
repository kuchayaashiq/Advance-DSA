package Graphs.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
    Given a directed graph. The task is to do Breadth First Search of this graph.
    Note: Graph does not contain multiple edges and self loops.
    Input Format
    The First line of test case contains two integers N and E which denotes the no of vertices and no of edges
    respectively.
    The Second line of test case contains E space separated pairs u and v denoting that there is edge from u to v .
    Output Format
    In a new line, print the BFS of the graph starting from 0.
    Example 1
    Input
        5 4
        0 1 0 2 0 3 2 4
    Output
        0 1 2 3 4
* */
public class BFS_UsingAdjacencyMatrix {
    private static class Graph {
        public int vertices;
        public ArrayList<Integer>[] adjList;
        Graph(int v) {
            this.vertices = v;
            adjList = new ArrayList[v];
            for (int i = 0; i < v; i++)
                adjList[i] = new ArrayList<Integer>();
        }
        void addEdge(int v, int w) {
            adjList[v].add(w);
        }
        void BFS(int src) {
            // your code here
            boolean[] vis = new boolean[vertices];

            Queue<Integer> que = new LinkedList<>();

            que.add(src);
            //int level = 0;
            vis[src] = true;
            while(!que.isEmpty()){

                int vtx = que.poll();

                for(int i = 0; i<adjList[vtx].size(); i++){
                    int nbr = adjList[vtx].get(i);
                    if(!vis[nbr]){
                        que.add(nbr);
                        vis[nbr] = true;
                    }
                }
                System.out.print(vtx+" ");
            }
        }
    }
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(n+1);
        for(int i =0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        g.BFS(0);
    }
}
