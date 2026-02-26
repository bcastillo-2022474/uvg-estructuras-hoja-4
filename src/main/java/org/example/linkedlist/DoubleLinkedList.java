package org.example.linkedlist;

class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T value) {
        this.value = value;
    }
}

public class DoubleLinkedList<T> implements ILinkedList<T> {
    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size;

    @Override
    public void Add(T element) {
        Node<T> newNode = new Node<>(element);

        if (size == 0) {
            firstElement = newNode;
            lastElement = newNode;
            size = 1;
            return;
        }

        newNode.prev = lastElement;
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

        Node<T> newNode = new Node<>(element);

        if (position == 0) {
            newNode.next = firstElement;
            firstElement.prev = newNode;
            firstElement = newNode;
            size++;
            return;
        }

        Node<T> current = getNode(position);
        Node<T> before = current.prev;

        newNode.prev = before;
        newNode.next = current;
        before.next = newNode;
        current.prev = newNode;
        size++;
    }

    @Override
    public T Get(int position) {
        return getNode(position).value;
    }

    @Override
    public void Remove(int position) {
        if (size == 0) throw new RuntimeException("List is empty");

        Node<T> node = getNode(position);
        Node<T> before = node.prev;
        Node<T> after = node.next;

        if (before == null) {
            firstElement = after;
        } else {
            before.next = after;
        }

        if (after == null) {
            lastElement = before;
        } else {
            after.prev = before;
        }

        node.prev = null;
        node.next = null;
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

    private Node<T> getNode(int position) {
        if (position < 0 || position >= size) {
            throw new RuntimeException("Index out of bounds");
        }

        boolean walkBackward = position > (size / 2);

        if (walkBackward) {
            Node<T> curr = lastElement;
            for (int i = size - 1; i > position; i--) {
                curr = curr.prev;
            }
            return curr;
        } else {
            Node<T> curr = firstElement;
            for (int i = 0; i < position; i++) {
                curr = curr.next;
            }
            return curr;
        }
    }
}
