package Graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
        Input Format
            The first line consists of two space separated integers N and M denoting the number of
            vertices and number of edges.
            Then in the next M line are 2 space separated integers u,v denoting an undirected
            edge between u and v.
        Output Format
            Return true if the graph consists Hamilton cycles, else return false.
        Example 1                                    Example 2           Explanation
        Input1                                           Input2             The graph is
            4 3                                             4 4           1----2----3
            1 2                                             1 2             \      /
            2 3                                             2 3              \    /
            2 4                                             3 4                4
        Output                                              1 4        The Hamilton path is 1-2-3-4
            0                                            Output
                                                               1

        * */

public class HamiltonianPathCycle_2ndWay {
    static class Edge {
        int u;
        int v;

        public Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
    }
    public static void addEdge(ArrayList<Edge>[] graph,int u, int v){
        graph[u].add(new Edge(u, v));
        graph[v].add(new Edge(v, u));
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            addEdge(graph,sc.nextInt()-1, sc.nextInt()-1);
        }
        if (check(N, M,graph)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }
    static boolean ans = false;

    static boolean check(int N, int M, ArrayList<Edge>[] graph) {
        // your code here
        hamiltonianPathCycle(graph, 0, 0,new boolean[N], 0,"", N);
        return ans;

    }

    public static void hamiltonianPathCycle(ArrayList<Edge>[] graph,int osrc, int src, boolean[] vis, int edgeCount, String psf, int N){
        if(edgeCount == N-1){
            if(checkifEdgeExist(graph,src,osrc)){
                System.out.println("This is a hamiltonian cycle "+psf);
                ans = true;
            } else {
                System.out.println("This is a hamiltonian path "+psf);

            }
            return;
        }

        vis[src] = true;

        for(Edge e: graph[src]){
            int nbr = e.v;
            if(!vis[nbr]){
                hamiltonianPathCycle(graph,osrc, nbr, vis, edgeCount + 1, psf+nbr, N);
            }
        }

        vis[src] = false;
    }

    public static boolean checkifEdgeExist(ArrayList<Edge>[] graph, int u, int v){
        for(Edge e:graph[u]){
            if(e.v == v){
                return true;
            }
        }

        return false;
    }
}
