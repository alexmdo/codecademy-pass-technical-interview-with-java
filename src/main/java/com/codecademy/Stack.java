package com.codecademy;

public class Stack {

    private LinkedList stack;
    private int size;
    private static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    private int maxSize;

    public Stack() {
        this(DEFAULT_MAX_SIZE);
    }

    public Stack(int maxSize) {
        this.stack = new LinkedList();
        this.maxSize = maxSize;
        this.size = 0;
    }

    public String pop() {
        if (!this.isEmpty()) {
            var data = this.stack.removeHead();
            this.size--;
            return data;
        } else {
            throw new RuntimeException("Stack is empty!");
        }
    }

    public String peek() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.stack.getHead().getData();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(String data) {
        if (this.hasSpace()) {
            this.stack.addToHead(data);
            this.size++;
        } else {
            throw new RuntimeException("Stack is full!");
        }
    }

    public boolean hasSpace() {
        return this.size < maxSize;
    }

    public String printStack() {
        return stack.printList();
    }

    public static void main(String[] args) {
        var s = new Stack(10);
        for (int i = 0; i < s.maxSize; i++) {
            s.push("Data " + i);
        }

        System.out.println(s.printStack());

        s.pop();
        System.out.println(s.printStack());

        System.out.println(s.peek());
        System.out.println(s.printStack());

        var size = s.size;
        for (int i = 0; i < size; i++) {
            System.out.println("Removed " + s.pop());
        }

        System.out.println(s.printStack());
    }

}
