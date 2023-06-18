package com.codecademy;

public class Node {

    private final String data;
    private Node next;
    private Node previous;

    public Node(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public String getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
