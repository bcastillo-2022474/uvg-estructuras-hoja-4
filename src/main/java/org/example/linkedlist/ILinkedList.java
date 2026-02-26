package org.example.linkedlist;

public interface ILinkedList<T> {
    void Add(T element);
    void Insert(int position, T element);
    T Get(int position);
    void Remove(int position);
    int Size();
    boolean isEmpty();
}
