package org.example.basic;

public class MyQueue {
    private int[] array;
    private int headIndex;
    private int tailIndex;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    public void enqueue(int data) {
        if ((tailIndex + 1) % array.length == headIndex) {
            throw new RuntimeException("queue is full");
        }
        array[headIndex] = data;
        tailIndex = increaseIndex(tailIndex);
    }

    public int dequeue() {
        int data = array[headIndex];
        headIndex = increaseIndex(headIndex);
        return data;
    }

    private int increaseIndex(int index) {
        return (++index) % array.length;
    }
}