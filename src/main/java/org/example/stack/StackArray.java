package org.example.stack;

public class StackArray<T> implements Stack<T> {
    public static int MAX_INITIAL_LENGTH = 10;
    private T[] items;
    int topIndex = -1;

    public StackArray(int capacity) {
        this.items = (T[]) new Object[capacity];
    }


    public StackArray() {
        this.items = (T[]) new Object[MAX_INITIAL_LENGTH];
    }

    private T[] generateNewArray() {
        int newCap = this.items.length * 2;
        T[] newItems = (T[]) new Object[newCap];
        for (int i = 0; i <= topIndex; i++) {
            newItems[i] = this.items[i];
        }
        return newItems;
    }

    @Override
    public void push(T item) {
        if (topIndex + 1 == this.items.length) {
            this.items = generateNewArray();
        }

        topIndex++;
        this.items[topIndex] = item;
    }

    @Override
    public T pop() {
        if (topIndex < 0) throw new IllegalArgumentException("Stack is empty");

        T element = this.items[this.topIndex];

        this.items[topIndex] = null;
        topIndex--;
        return element;
    }

    @Override
    public T peek() {
        if (topIndex < 0) throw new IllegalArgumentException("Stack is empty");
        return this.items[this.topIndex];
    }
}