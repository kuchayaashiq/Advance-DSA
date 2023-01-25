package Graphs;

import java.util.ArrayList;

public class CountComponents {
    static class Edge {
        int u;
        int v;

        public Edge(int u, int v){
            this.u = u;
            this.v = v;
        }

        public String toString(){
            return "Edge is from " + this.u + " to " + this.v ;
        }
    }

    static int N = 10; // number of vertex
    @SuppressWarnings("unchecked")
    static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void constructGraph(){
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(0,1);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(0, 3);
        addEdge(4, 5);
        addEdge(4, 6);
        addEdge(7, 8);
        addEdge(7, 9);
        addEdge(8, 9);

    }

    public static void addEdge(int u, int v){
        graph[u].add(new Edge(u, v));
        graph[v].add(new Edge(v, u));
    }

    public static void dfs(int src, boolean[] vis){
        vis[src]= true;

        for(Edge e: graph[src]){
            int nbr = e.v;
            if(!vis[nbr]){
                dfs(nbr, vis);
            }
        }
    }

    public static int numberOfComponents(){
        boolean[] visited = new boolean[N];
        int count=0;

        for(int i=0; i<N; i++){
            if(visited[i]==false){
                dfs(i,visited);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        constructGraph();
        System.out.println(numberOfComponents());

        //hamiltonianPathCycle(0, 0,new boolean[N], 0, "0");
    }
}
