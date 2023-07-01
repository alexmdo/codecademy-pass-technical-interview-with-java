package com.codecademy;

import java.util.Objects;

public class HashMap {

    private LinkedList[] hashmap;

    public HashMap(int size) {
        this.hashmap = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            this.hashmap[i] = new LinkedList();
        }
    }

    public String retrieve(String key) {
        var arrayIndex = this.hash(key);
        var current = this.hashmap[arrayIndex].getHead();

        while (current != null) {
            if (Objects.equals(current.getKey(), key)) {
                return current.getData();
            }

            current = current.getNext();
        }

        return null;
    }

    public void assign(String key, String value) {
        var arrayIndex = this.hash(key);
        var list = this.hashmap[arrayIndex];

        if (list.getHead() == null) {
            list.addToHead(key, value);
            return;
        }

        var current = list.getHead();
        while (current != null) {
            if (Objects.equals(current.getKey(), key)) {
                current.setKeyValue(key, value);
                break;
            }

            if (current.getNext() == null) {
                current.setNext(new Node(key, value));
                break;
            }

            current = current.getNext();
        }
    }

    private int hash(String key) {
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode += Character.codePointAt(key, i);
        }

        hashCode %= this.hashmap.length;
        return hashCode;
    }

    public static void main(String[] args) {
        var hashMap = new HashMap(10);
        for (int i = 0; i < 10; i++) {
            hashMap.assign("key" + i, "Value" + i);
        }

        print(hashMap);

        hashMap.assign("key" + 1, "Value" + 11);
        hashMap.assign("key" + 2, "Value" + 22);

        print(hashMap);

    }

    private static void print(HashMap hashMap) {
        for (LinkedList linkedList : hashMap.hashmap) {
            System.out.println(linkedList.printList());
        }
        System.out.println("----------------");
    }

}
