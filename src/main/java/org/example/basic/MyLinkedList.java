package org.example.basic;

public class MyLinkedList {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private int size = 0;
    private Node head;
    private Node tail;

    public MyLinkedList() {

    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node target = head;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target;
    }

    public void insert(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(data);
        if (0 == size) {
            head = tail = newNode;
        } else if (0 == index) {
            newNode.next = head.next;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node preNode = get(index - 1);
            newNode.next = preNode.next;
            preNode.next = newNode;
        }
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (0 == index) {
            head = head.next;
        } else {
            Node preNode = get(index - 1);
            Node targetNode = preNode.next;
            preNode.next = targetNode.next;
            if (index == size - 1) {
                tail = preNode;
            }
        }
        size--;
    }
}
