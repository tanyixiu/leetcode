package org.example.basic;

public class MyArray {
    private int currentSize;
    int[] array;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        this.currentSize = 0;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException("out of index");
        }

        if (currentSize >= array.length) {
            resize();
        }

        for (int i = currentSize - 1; i >= index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        currentSize++;
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void delete(int index, int value) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("out of index");
        }
        for (int i = index; i < currentSize - 1; i++) {
            array[i] = array[i + 1];
        }
        currentSize--;
    }
}
