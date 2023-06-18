package com.codecademy;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node currentHead = this.head;

        if (currentHead != null) {
            currentHead.setPrevious(newHead);
            newHead.setNext(currentHead);
        }
        this.head = newHead;

        if (this.tail == null) {
            this.tail = newHead;
        }
    }

    public void addToTail(String data) {
        Node newTail = new Node(data);
        Node currentTail = this.tail;

        if (currentTail != null) {
            currentTail.setNext(newTail);
            newTail.setPrevious(currentTail);
        }
        this.tail = newTail;

        if (this.head == null) {
            this.head = newTail;
        }
    }

    public String removeHead() {
        Node removedHead = this.head;

        if (removedHead == null) {
            return null;
        }

        this.head = removedHead.getNext();

        if (this.head != null) {
            this.head.setPrevious(null);
        }

        if (removedHead == this.tail) {
            this.removeTail();
        }

        return removedHead.getData();
    }

    public String removeTail() {
        Node removedTail = this.tail;

        if (removedTail == null) {
            return null;
        }

        this.tail = removedTail.getPrevious();

        if (this.tail != null) {
            this.tail.setNext(null);
        }

        if (removedTail == this.head) {
            this.removeHead();
        }

        return removedTail.getData();
    }

    public Node removeByData(String data) {
        Node nodeToRemove = null;
        Node currentNode = this.head;

        while (currentNode != null) {
            if (currentNode.getData() == data) {
                nodeToRemove = currentNode;
                break;
            }
            currentNode = currentNode.getNext();
        }

        if (nodeToRemove == null) {
            return null;
        }

        if (nodeToRemove == this.head) {
            this.removeHead();
        } else if (nodeToRemove == this.tail) {
            this.removeTail();
        } else {
            Node nextNode = nodeToRemove.getNext();
            Node previousNode = nodeToRemove.getPrevious();
            nextNode.setPrevious(previousNode);
            previousNode.setNext(nextNode);
        }

        return nodeToRemove;
    }

    public String printList() {
        Node currentNode = this.head;
        String output = "<head> ";

        while (currentNode != null) {
            output += currentNode.getData() + " ";
            currentNode = currentNode.getNext();
        }

        output += "<tail>";

        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addToHead("h1");
        dll.addToHead("h2");
        dll.addToHead("h3");
        dll.addToHead("h4");
        dll.addToHead("h5");
        dll.addToTail("t1");
        dll.addToTail("t2");
        dll.addToTail("t3");
        dll.addToTail("t4");
        dll.removeByData("h4");
        dll.removeHead();
        dll.removeTail();
        dll.printList();

    }

}
