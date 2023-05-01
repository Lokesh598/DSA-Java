package algorithm.graph.DFS;

import java.util.ArrayList;

public class DFS {

    static void dfsUtils( int start, boolean[] vis,
                          ArrayList<ArrayList<Integer>> adj,
                          ArrayList<Integer> res) {

        vis[start] = true;
        res.add(start);

        for(int it : adj.get(start)) {
            if(!vis[it]) {
                dfsUtils(it, vis, adj, res);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];

        ArrayList<Integer> res = new ArrayList<>();

        dfsUtils(0, vis, adj, res);
        return res;
    }
}
