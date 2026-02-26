package org.example.stack;

/**
 * Abstract base class for stack implementations.
 * Provides a shared isEmpty() implementation based on peek().
 * @param <T> Type of elements stored in the stack
 */
public abstract class AbstractStack<T> implements Stack<T> {

    @Override
    public abstract void push(T element);

    @Override
    public abstract T pop();

    @Override
    public abstract T peek();

    public boolean isEmpty() {
        try {
            peek();
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
}
