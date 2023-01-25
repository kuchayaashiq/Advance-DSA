package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
/*
    You are given a graph, a source vertex, and a destination vertex.
    You are also given a number named "criteria" and a number "k".
    You are required to find and print the values of the Largest path and its weight separated by an "@",
     just a smaller path (than criteria in terms of weight), also known as floor path, and its weight separated
     by an "@" and finally Kth largest path, and it's weight separated by an "@".

    Input Format
        Input has been managed for you.
    Output Format
        Output has been managed for you. You just need to give correct values to the variables already
        initialized for you.

    Example 1
    Input
    7
    9
    0 1 10
    1 2 10
    2 3 10
    0 3 40
    3 4 2
    4 5 3
    5 6 3
    4 6 8
    2 5 5
    0
    6
    30
    4
    Output
    Largest Path = 032546@66
    Just Smaller Path than 30 = 01256@28
    4th largest path = 03456@48
* */

public class LargestPath {
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String fpath;

    //Solution
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        int criteria = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        multiSolver(graph, src, dest, visited, criteria, k, src + "", 0);

        System.out.println("Largest Path = " + lpath + "@" + lpathwt);
        System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
        System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
    }

    public static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
        //write code here
        //All variables have been initialized for you at the top of the function
        if (src == dest) {
            pq.add(new Pair(wsf, psf));
            if (pq.size() > k) {
                pq.remove();
            }

            if (wsf > lpathwt) {
                lpath = psf;
                lpathwt = wsf;
            }

            if (wsf < criteria && wsf > fpathwt) {
                fpathwt = wsf;
                fpath = psf;
            }
            return;
        }

        visited[src] = true;

        for (Edge e : graph[src]) {
            int nbr = e.nbr;
            if (!visited[nbr]) {
                multiSolver(graph, nbr, dest, visited, criteria, k, psf + nbr, wsf + e.wt);
            }
        }

        visited[src] = false;
    }

    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }
}
