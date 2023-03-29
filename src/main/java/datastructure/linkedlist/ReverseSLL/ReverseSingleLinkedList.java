package datastructure.linkedlist.ReverseSLL;

class ReverseSingleLinkedList {
    static void printList(Node node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
    public static void main(String[] args) {
        Solution obj = new Solution();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node node = obj.reverseLinkedList(head);
        printList(node);
    }
}
class Node {
    int data;
    Node next;
    Node (int value) {
        data = value;
        next = null;
    }
}
class Solution {
    Node reverseLinkedList(Node head) {
        Node p = null;
        Node q = null;
        while(head!=null) {
            p=q;
            q=head;
            head=head.next;
            q.next=p;
        }
        return q;
    }
}
