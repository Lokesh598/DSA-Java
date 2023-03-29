package algorithm.graph.BFS;

import java.util.*;

class BFS {
    public static void main(String[] args) {
        Solution obj = new Solution();
//        obj.bfsOfGraph(V, adj);
    }
}

class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i<V; i++) {
            vis[i] = false;
        }

        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        //make first visited
        vis[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            Iterator<Integer> i = adj.get(node).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if(!vis[n]) {
                    vis[n] = true;
                    queue.add(n);
                }
            }
        }
        return res;
    }
}
