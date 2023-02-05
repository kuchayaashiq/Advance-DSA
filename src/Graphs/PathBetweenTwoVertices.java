package Graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PathBetweenTwoVertices {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        int U=sc.nextInt();
        int V=sc.nextInt();
        if (check(N, M, Edges,U,V)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }
    static boolean hasPath(int src, int des, ArrayList<Integer>[] graph, boolean[] vis){
        if(src == des){
            return true;
        }

        boolean ans = false;
        vis[src]= true;
        for(int nbr: graph[src]){
            if(!vis[nbr]){
                ans = ans || hasPath(nbr, des, graph, vis);
            }
        }

        vis[src] = false;
        return ans;
    }

    private  static boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges, int U, int V) {
        // N vertices, M edges
        ArrayList<Integer>[] graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        for(ArrayList<Integer> edge:Edges){
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u-1].add(v-1);
        }

        return hasPath(U-1, V-1, graph, new boolean[N]) || hasPath(V-1, U-1, graph,new boolean[N]);
    }
}
