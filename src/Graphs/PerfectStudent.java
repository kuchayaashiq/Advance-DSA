package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

/*
        Input Format
        The first line contains a number of students n.
        The next line contains number of clubs k.
        Next k lines contain two space separated integers. The numbers are ids of students belonging to same club.
        Output Format
        Number of ways can we select a pair of students such that both students are from different clubs.
        Example 1
        Input
        10
        6
        2 4
        6 2
        3 6
        2 1
        2 3
        1 2
        Output
        35


* */

class Edge {
    int src;
    int nbr;

    Edge(int src, int nbr) {
        this.src = src;
        this.nbr = nbr;
    }
}
public class PerfectStudent {
    public static void addEdge(ArrayList<Edge>[] graph,int u, int v){
        graph[u].add(new Edge(u, v));
        graph[v].add(new Edge(v, u));
    }
    public static int getSize(int src, boolean[] vis, ArrayList<Edge>[] graph){
        vis[src]= true;

        int ans = 0;
        for(Edge e: graph[src]){
            int nbr = e.nbr;
            if(vis[nbr]==false){
                int nbrSize = getSize(nbr, vis, graph);
                ans += nbrSize;
            }
        }

        return ans + 1;
    }
    public static int perfectStudents(int vtces,  ArrayList<Edge>[] graph){
        ArrayList<Integer> components = new ArrayList<>();

        boolean[] visited = new boolean[vtces];
        for(int i=0; i<vtces; i++){
            if(visited[i]==false){
                int size  = getSize(i,visited,graph);
                components.add(size);
            }
        }
        // count size of every component and store in components arraylist
        // Then find how many pairs are not connected
        int pairs=0;
        for(int i=0; i<components.size(); i++){
            int s1 = components.get(i);
            for(int j=i+1; j<components.size(); j++){
                int s2 = components.get(j);
                pairs = pairs +(s1*s2);
            }
        }

        return pairs;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //  Number of vertices
        int M = sc.nextInt();   // Number of edges

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            addEdge(graph,sc.nextInt(), sc.nextInt());
        }
        System.out.println(perfectStudents(N, graph));
    }
}
