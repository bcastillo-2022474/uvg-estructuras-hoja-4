package org.example.factory;

import org.example.linkedlist.DoubleLinkedList;
import org.example.linkedlist.ILinkedList;
import org.example.linkedlist.LinkedList;
import org.example.parser.Token;

/**
 * Factory for creating linked list implementations.
 */
public class ListFactory {

    /**
     * Creates a linked list based on the chosen type.
     * @param type 1 = singly linked, 2 = doubly linked
     * @return An ILinkedList implementation
     */
    public static ILinkedList<Token> createList(int type) {
        if (type == 2) {
            return new DoubleLinkedList<>();
        }
        return new LinkedList<>();
    }
}
