package datastructure.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Shortest_Path_In_An_Unweighted_Graph {
    public ArrayList<Integer> shortestPath(ArrayList<ArrayList<Integer>> adj,int s, int V, int[] dist){
        dist[s] = 0;
        boolean[] vis = new boolean[V];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(s);
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v : adj.get(u)) {
                if (vis[v]== false) {
                    dist[v] = dist[u] + 1;
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Shortest_Path_In_An_Unweighted_Graph obj = new Shortest_Path_In_An_Unweighted_Graph();

        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));

        Scanner sc = new Scanner(System.in);
        String[] s = br.readLine().trim().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] dist = new int[V];
        for (int i = 0; i<V; i++) {
            adj.add(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < E; i++) {
            String[] S = br.readLine().trim().split(" ");
            int u = Integer.parseInt(S[0]);
            int v = Integer.parseInt(S[1]);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //setting a dist array
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        ArrayList<Integer> res = obj.shortestPath(adj, 0, V, dist);

        for (Integer re : res) {
            System.out.print(re+" ");
        }
        System.out.println();
    }
}
