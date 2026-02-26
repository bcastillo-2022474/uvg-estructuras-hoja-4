package org.example.factory;

import org.example.parser.Token;
import org.example.stack.Stack;
import org.example.stack.StackArray;
import org.example.stack.StackArrayList;
import org.example.stack.StackLinkedList;

/**
 * Factory for creating stack implementations.
 */
public class StackFactory {

    /**
     * Creates a stack based on the chosen type.
     * @param type 1 = ArrayList, 2 = Array, 3 = LinkedList
     * @param listType Only used when type=3: 1 = singly linked, 2 = doubly linked
     * @return A Stack implementation
     */
    public static Stack<Token> createStack(int type, int listType) {
        switch (type) {
            case 2:
                return new StackArray<>();
            case 3:
                return new StackLinkedList<>(ListFactory.createList(listType));
            default:
                return new StackArrayList<>();
        }
    }

    public static Stack<Token> createStack(int type) {
        return createStack(type, 1);
    }
}
