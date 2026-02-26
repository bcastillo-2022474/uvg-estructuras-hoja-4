package org.example;

import org.example.stack.Stack;
import org.example.stack.StackArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackArrayListTest {

    @Test
    public void testPushAndPop() {
        Stack<Integer> stack = new StackArrayList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testPeek() {
        Stack<String> stack = new StackArrayList<>();
        stack.push("first");
        stack.push("second");

        assertEquals("second", stack.peek());
        assertEquals("second", stack.peek());
        assertEquals("second", stack.pop());
    }

    @Test
    public void testPopEmptyStack() {
        Stack<Integer> stack = new StackArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> {
            stack.pop();
        });
    }

    @Test
    public void testPeekEmptyStack() {
        Stack<Integer> stack = new StackArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> {
            stack.peek();
        });
    }

    @Test
    public void testStackWithCustomCapacity() {
        Stack<Integer> stack = new StackArrayList<>(5);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 9; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
    }

    @Test
    public void testStackLIFOOrder() {
        Stack<String> stack = new StackArrayList<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }
}
