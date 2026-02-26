package org.example.linkedlist;

/**
 * Abstract base class for linked list implementations.
 * Owns the size counter and provides Size() and isEmpty().
 * @param <T> Type of elements stored in the list
 */
public abstract class AbstractLinkedList<T> implements ILinkedList<T> {

    protected int size = 0;

    @Override
    public abstract void Add(T element);

    @Override
    public abstract void Insert(int position, T element);

    @Override
    public abstract T Get(int position);

    @Override
    public abstract void Remove(int position);

    @Override
    public int Size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
