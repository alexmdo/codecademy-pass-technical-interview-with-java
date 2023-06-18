package com.codecademy;

public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addToHead(String data) {
        var newHead = new Node(data);
        var currentHead = this.head;
        this.head = newHead;

        if (currentHead != null) {
            this.head.setNext(currentHead);
        }
    }

    public void addToTail(String data) {
        var newTail = new Node(data);
        var currentTail = this.head;

        if (currentTail != null) {
            while (currentTail.getNext() != null) {
                currentTail = currentTail.getNext();
            }

            currentTail.setNext(newTail);
        } else {
            this.head = newTail;
        }
    }

    public String removeHead() {
        var headToRemove = this.head;

        if (headToRemove == null) {
            return null;
        }

        this.head = headToRemove.getNext();
        return headToRemove.getData();
    }

    public String printList() {
        String output = "<head> ";
        var currentNode = this.head;

        while (currentNode != null) {
            output += currentNode.getData() + " ";
            currentNode = currentNode.getNext();
        }

        output += "<tail>";
        return output;
    }

}
