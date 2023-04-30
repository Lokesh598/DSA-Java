package algorithm.treetraversal;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Problem:
 * Given a binary tree, find its level order traversal.
 * Level order traversal of a tree is breadth-first traversal for the tree.
 *
 * Input:
 *         10
 *      /      \
 *     20       30
 *   /   \
 *  40   60
 * Output:10 20 30 40 60
 *
 */
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class LevelOrderTraversal {
    static ArrayList<Integer> levelOrder(Node node)
    {
        // Your code here
        ArrayList <Integer> res = new ArrayList <Integer> (0);
        if (node == null)
            return res;
        //creating an empty queue
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            Node tmp = q.peek();
            q.poll();
            res.add(tmp.data);
            //storing left child of the parent node
            if(tmp.left!=null)
                q.add(tmp.left);
            // storing right child of the parent node
            if(tmp.right!=null)
                q.add(tmp.right);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
