package org.example;

import org.example.linkedlist.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void testAddAndGet() {
        LinkedList<Integer> list = new LinkedList<>();
        list.Add(1);
        list.Add(2);
        list.Add(3);

        assertEquals(1, list.Get(0));
        assertEquals(2, list.Get(1));
        assertEquals(3, list.Get(2));
    }

    @Test
    public void testSize() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(0, list.Size());

        list.Add("a");
        assertEquals(1, list.Size());

        list.Add("b");
        list.Add("c");
        assertEquals(3, list.Size());
    }

    @Test
    public void testIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.Add(42);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testRemoveFromMiddle() {
        LinkedList<Integer> list = new LinkedList<>();
        list.Add(1);
        list.Add(2);
        list.Add(3);

        list.Remove(1);

        assertEquals(2, list.Size());
        assertEquals(1, list.Get(0));
        assertEquals(3, list.Get(1));
    }

    @Test
    public void testRemoveHead() {
        LinkedList<Integer> list = new LinkedList<>();
        list.Add(10);
        list.Add(20);
        list.Add(30);

        list.Remove(0);

        assertEquals(2, list.Size());
        assertEquals(20, list.Get(0));
        assertEquals(30, list.Get(1));
    }

    @Test
    public void testRemoveTail() {
        LinkedList<Integer> list = new LinkedList<>();
        list.Add(10);
        list.Add(20);
        list.Add(30);

        list.Remove(2);

        assertEquals(2, list.Size());
        assertEquals(10, list.Get(0));
        assertEquals(20, list.Get(1));
    }

    @Test
    public void testRemoveSingleElement() {
        LinkedList<String> list = new LinkedList<>();
        list.Add("only");

        list.Remove(0);

        assertEquals(0, list.Size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testInsertAtHead() {
        LinkedList<Integer> list = new LinkedList<>();
        list.Add(2);
        list.Add(3);

        list.Insert(0, 1);

        assertEquals(3, list.Size());
        assertEquals(1, list.Get(0));
        assertEquals(2, list.Get(1));
        assertEquals(3, list.Get(2));
    }

    @Test
    public void testInsertAtMiddle() {
        LinkedList<Integer> list = new LinkedList<>();
        list.Add(1);
        list.Add(3);

        list.Insert(1, 2);

        assertEquals(3, list.Size());
        assertEquals(1, list.Get(0));
        assertEquals(2, list.Get(1));
        assertEquals(3, list.Get(2));
    }

    @Test
    public void testInsertAtEnd() {
        LinkedList<Integer> list = new LinkedList<>();
        list.Add(1);
        list.Add(2);

        list.Insert(2, 3);

        assertEquals(3, list.Size());
        assertEquals(3, list.Get(2));
    }

    @Test
    public void testGetOutOfBoundsThrows() {
        LinkedList<Integer> list = new LinkedList<>();
        list.Add(1);

        assertThrows(RuntimeException.class, () -> list.Get(5));
        assertThrows(RuntimeException.class, () -> list.Get(-1));
    }

    @Test
    public void testInsertOutOfBoundsThrows() {
        LinkedList<Integer> list = new LinkedList<>();

        assertThrows(RuntimeException.class, () -> list.Insert(-1, 99));
        assertThrows(RuntimeException.class, () -> list.Insert(5, 99));
    }

    @Test
    public void testRemoveOutOfBoundsThrows() {
        LinkedList<Integer> list = new LinkedList<>();
        list.Add(1);

        assertThrows(RuntimeException.class, () -> list.Remove(5));
        assertThrows(RuntimeException.class, () -> list.Remove(-1));
    }

    @Test
    public void testAddManyElements() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            list.Add(i);
        }

        assertEquals(20, list.Size());
        for (int i = 0; i < 20; i++) {
            assertEquals(i, list.Get(i));
        }
    }
}
