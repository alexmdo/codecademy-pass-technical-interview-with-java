package com.codecademy;

public class Queue {

    private static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    private final int maxSize;
    private final LinkedList queue;
    private int size;

    public Queue() {
        this(DEFAULT_MAX_SIZE);
    }

    public Queue(int maxSize) {
        this.queue = new LinkedList();
        this.maxSize = maxSize;
        this.size = 0;
    }


    private String dequeue() {
        if (!this.isEmpty()) {
            var data = this.queue.removeHead();
            this.size--;
            return data;
        } else {
            throw new RuntimeException("Queue is empty!");
        }
    }
    private String peak() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.queue.getHead().getData();
        }
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private void enqueue(String data) {
        if (this.hasSpace()) {
            this.queue.addToTail(data);
            this.size++;
        } else {
            throw new RuntimeException("Queue is full!");
        }
    }

    private boolean hasSpace() {
        return this.size < this.maxSize;
    }

    public static void main(String[] args) {
        var queueSize = 10;
        var q = new Queue(queueSize);

        for (int i = 0; i < queueSize; i++) {
            q.enqueue("Queue|" + i);
        }

        System.out.println(q.printQueue());
        System.out.println(q.peak());
        System.out.println(q.dequeue());
        System.out.println(q.printQueue());
        System.out.println(q.peak());

        for (int i = 0; i < queueSize; i++) {
            q.dequeue();
        }
    }

    private String printQueue() {
        return this.queue.printList();
    }

}
