package org.example.stack;

import org.example.linkedlist.ILinkedList;

/**
 * Stack implementation backed by a linked list (singly or doubly linked).
 * @param <T> Type of elements stored in the stack
 */
public class StackLinkedList<T> implements Stack<T> {
    private final ILinkedList<T> list;

    public StackLinkedList(ILinkedList<T> list) {
        this.list = list;
    }

    @Override
    public void push(T element) {
        list.Add(element);
    }

    @Override
    public T pop() {
        if (list.isEmpty()) throw new IllegalArgumentException("Stack is empty");
        int last = list.Size() - 1;
        T element = list.Get(last);
        list.Remove(last);
        return element;
    }

    @Override
    public T peek() {
        if (list.isEmpty()) throw new IllegalArgumentException("Stack is empty");
        return list.Get(list.Size() - 1);
    }
}
