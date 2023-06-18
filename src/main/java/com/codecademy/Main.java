package com.codecademy;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addToHead("Head1");
        ll.addToHead("Head2");
        ll.addToHead("Head3");
        ll.addToTail("tail1");
        ll.addToHead("Head4");
        ll.addToHead("Head5");
        ll.addToHead("Head6");
        ll.addToTail("tail2");
        ll.removeHead();
        System.out.println(ll.printList());
    }
}