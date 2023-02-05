package Graphs.BFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
*           10 20
            4 9
            9 2
            8 9
            5 1
            7 5
            6 5
            1 4
            7 3
            7 4
            1 2
            3 0
            8 2
            6 9
            0 2
            4 8
            6 1
            4 2
            0 8
            5 8
            7 2
            0 4

* */
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
        int src=sc.nextInt();
        int des=sc.nextInt();
        if (check(N, Edges,src,des)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

    private static boolean check(int n, ArrayList<ArrayList<Integer>> adj, int src, int des) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        if(src == des){
            return  true;
        }
        q.add(src);
        visited[src] = true;
        while (!q.isEmpty()){
            src = q.remove();
            for (int i = 0; i < adj.get(src).size(); i++) {
                if(adj.get(src).get(i) == des){
                    return true;
                }
               if ( !visited[adj.get(src).get(i)]){
                   visited[adj.get(src).get(i)] = true;
                   q.add(adj.get(src).get(i));
               }
            }
        }
        return false;
    }



}
