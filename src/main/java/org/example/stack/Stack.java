package org.example.stack;

/**
 * Generic stack interface with basic operations
 * @param <T> Type of elements stored in the stack
 */
public interface Stack<T> {
    /**
     * Pushes an element onto the stack
     * @param element Element to push
     */
    public void push(T element);

    /**
     * Removes and returns the top element
     * @return The top element
     * @throws IllegalArgumentException if stack is empty
     */
    public T pop();

    /**
     * Returns the top element without removing it
     * @return The top element
     * @throws IllegalArgumentException if stack is empty
     */
    public T peek();
}
