package org.example;

import java.util.ArrayList;
import java.util.List;

public class StackArrayList<T> implements Stack<T> {
    int MAX_INITIAL_LENGTH = 10;
    List<T> items;

    public StackArrayList(int capacity) {
        this.items = new ArrayList<>(capacity);
    }


    public StackArrayList() {
        this.items = new ArrayList<>(this.MAX_INITIAL_LENGTH);
    }

    @Override
    public void push(T item) {
        this.items.add(item);
    }

    @Override
    public T pop() {
        if (this.items.size() == 0) throw new IllegalArgumentException("Stack is empty");
        int topIndex = this.items.size() - 1;
        T item = this.items.get(topIndex);
        this.items.remove(topIndex);
        return item;
    }

    @Override
    public T peek() {
        if (this.items.size() == 0) throw new IllegalArgumentException("Stack is empty");
        return this.items.get(this.items.size() - 1);
    }
}