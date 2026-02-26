package org.example;

import org.example.linkedlist.DoubleLinkedList;
import org.example.linkedlist.LinkedList;
import org.example.stack.Stack;
import org.example.stack.StackLinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackLinkedListTest {

    // --- Tests with singly linked list backing ---

    @Test
    public void testPushAndPopSingly() {
        Stack<Integer> stack = new StackLinkedList<>(new LinkedList<>());
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testPeekSingly() {
        Stack<String> stack = new StackLinkedList<>(new LinkedList<>());
        stack.push("first");
        stack.push("second");

        assertEquals("second", stack.peek());
        assertEquals("second", stack.peek());
        assertEquals("second", stack.pop());
        assertEquals("first", stack.peek());
    }

    @Test
    public void testPopEmptySingly() {
        Stack<Integer> stack = new StackLinkedList<>(new LinkedList<>());
        assertThrows(IllegalArgumentException.class, stack::pop);
    }

    @Test
    public void testPeekEmptySingly() {
        Stack<Integer> stack = new StackLinkedList<>(new LinkedList<>());
        assertThrows(IllegalArgumentException.class, stack::peek);
    }

    @Test
    public void testLIFOOrderSingly() {
        Stack<String> stack = new StackLinkedList<>(new LinkedList<>());
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    public void testManyElementsSingly() {
        Stack<Integer> stack = new StackLinkedList<>(new LinkedList<>());
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        for (int i = 19; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
    }

    // --- Tests with doubly linked list backing ---

    @Test
    public void testPushAndPopDoubly() {
        Stack<Integer> stack = new StackLinkedList<>(new DoubleLinkedList<>());
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    public void testPeekDoubly() {
        Stack<String> stack = new StackLinkedList<>(new DoubleLinkedList<>());
        stack.push("x");
        stack.push("y");

        assertEquals("y", stack.peek());
        assertEquals("y", stack.pop());
        assertEquals("x", stack.peek());
    }

    @Test
    public void testPopEmptyDoubly() {
        Stack<Integer> stack = new StackLinkedList<>(new DoubleLinkedList<>());
        assertThrows(IllegalArgumentException.class, stack::pop);
    }

    @Test
    public void testPeekEmptyDoubly() {
        Stack<Integer> stack = new StackLinkedList<>(new DoubleLinkedList<>());
        assertThrows(IllegalArgumentException.class, stack::peek);
    }

    @Test
    public void testLIFOOrderDoubly() {
        Stack<String> stack = new StackLinkedList<>(new DoubleLinkedList<>());
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    public void testManyElementsDoubly() {
        Stack<Integer> stack = new StackLinkedList<>(new DoubleLinkedList<>());
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        for (int i = 19; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
    }
}
