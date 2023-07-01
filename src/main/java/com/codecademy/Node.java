package com.codecademy;

public class Node {

    private String key;
    private String data;
    private Node next;
    private Node previous;

    public Node(String key, String data) {
        this.key = key;
        this.data = data;
        this.next = null;
    }

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

    public String getKey() {
        return key;
    }

    public void setKeyValue(String key, String data) {
        this.key = key;
        this.data = data;
    }
}
