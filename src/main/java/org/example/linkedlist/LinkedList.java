package org.example.linkedlist;

class LinkedNode<T> {
    public T value;
    public LinkedNode<T> next;

    public LinkedNode(T value) {
        this.value = value;
    }
}

public class LinkedList<T> implements ILinkedList<T> {
    private LinkedNode<T> firstElement;
    private LinkedNode<T> lastElement;
    private int size;

    @Override
    public void Add(T element) {
        LinkedNode<T> newNode = new LinkedNode<>(element);

        if (size == 0) {
            firstElement = newNode;
            lastElement = newNode;
            size = 1;
            return;
        }

        lastElement.next = newNode;
        lastElement = newNode;
        size++;
    }

    @Override
    public void Insert(int position, T element) {
        if (position < 0 || position > size) {
            throw new RuntimeException("Index out of bounds");
        }

        if (position == size) {
            Add(element);
            return;
        }

        LinkedNode<T> newNode = new LinkedNode<>(element);

        if (position == 0) {
            newNode.next = firstElement;
            firstElement = newNode;
            size++;
            return;
        }

        LinkedNode<T> prev = getNode(position - 1);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    @Override
    public T Get(int position) {
        return getNode(position).value;
    }

    @Override
    public void Remove(int position) {
        if (size == 0) throw new RuntimeException("List is empty");

        if (position == 0) {
            firstElement = firstElement.next;
            if (size == 1) lastElement = null;
            size--;
            return;
        }

        LinkedNode<T> prev = getNode(position - 1);
        LinkedNode<T> toRemove = prev.next;
        prev.next = toRemove.next;
        if (toRemove == lastElement) {
            lastElement = prev;
        }
        toRemove.next = null;
        size--;
    }

    @Override
    public int Size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private LinkedNode<T> getNode(int position) {
        if (position < 0 || position >= size) {
            throw new RuntimeException("Index out of bounds");
        }

        LinkedNode<T> curr = firstElement;
        for (int i = 0; i < position; i++) {
            curr = curr.next;
        }
        return curr;
    }
}
