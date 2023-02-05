package Graphs.DFS;
/*
    You are given an undirected graph with N vertices. You have to find the number of connected
    components in the graph.
    Note: Complete the given function. The input and output would be handled by the driver code.
    A set of vertices forms a connected component in an undirected graph if any vertex from
    the set of vertices can reach any other vertex by traversing edges.
    Input Format
    The first line of the input contains N.
    and next N lines consists of N integers each of the adjacency matrix adj.
    If adj[u][v] is 1, it means there is an edge between u and v.
    Output Format
    Print the answer in a new line.
    Example 1
    Input
    3
    1 1 0
    1 1 0
    0 0 1
    Output
    2
    Explanation
    The graph has two components. [1, 2], and [3].
    Example 2
    Input
    2
    1 0
    0 1
    Output
    2
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CountComponentsUsingDFS {

    public static int  components(int V, ArrayList<ArrayList<Integer>>adj) {

        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;

            }
        }
        return count;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        for (int j = 0; j < adj.get(i).size(); j++)
        {
            if (i!=j && adj.get(i).get(j) == 1 && !visited[j])
            {
                visited[j] = true;
                dfs(j, adj, visited);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<N; i++)
        {
            String S[] = read.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<N; j++)
                temp.add(Integer.parseInt(S[j]));
            adj.add(temp);
        }

        System.out.println(components(N,adj));
    }
}
