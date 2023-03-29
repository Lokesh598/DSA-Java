package datastructure.linkedlist.DetectLoopinlinkedlist;

import java.rmi.UnexpectedException;

class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
}
public class DetectLoop {
    public static void makeLoop(Node head, Node tail, int pos) {
        Node cur = head;
        for (int i = 0; i<pos; i++) {
            cur = cur.next;
        }
        tail.next = cur;
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        Node tail = node;
        while(tail.next != null) {
            tail = tail.next;
        }
        makeLoop(node, tail, 0);
        if(Solution.detectLoop(node))
            System.out.println("True");
        else
            System.out.println("False");
    }
}
class Solution {
    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}