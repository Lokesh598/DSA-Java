package priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(40);
        priorityQueue.add(20);
        priorityQueue.add(30);
        priorityQueue.add(15);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
    }
}
