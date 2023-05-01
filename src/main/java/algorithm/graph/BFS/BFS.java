package algorithm.graph.BFS;

import java.util.*;


/**
 * Input:
 *          0
 *        / |  \
 *       1  2   3
 *          |
 *          4
 * Output: 0 1 2 3 4
 * Explanation:
 * 0 is connected to 1 , 2 , 3.
 * 2 is connected to 4.
 * so starting from 0, it will go to 1 then 2
 * then 3.After this 2 to 4, thus bfs will be
 * 0 1 2 3 4.
 */
class BFS {
    public static void main(String[] args) {
        Solution obj = new Solution();
//        obj.bfsOfGraph(V, adj);
    }
}

class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // visiting guy
        boolean[] vis = new boolean[V];
        // we dont need to initialize visited array, it is not required
        for (int i = 0; i<V; i++) {
            vis[i] = false;
        }

        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        //make first visited
        vis[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.peek();
            res.add(node);
            queue.poll();
//            Iterator<Integer> i = adj.get(node).listIterator();
//            while (i.hasNext()) {
//                int n = i.next();
//                if(!vis[n]) {
//                    vis[n] = true;
//                    queue.add(n);
//                }
//            }
            //enhanced for loop
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    queue.add(it);
                }
            }
        }
        return res;
    }
}
