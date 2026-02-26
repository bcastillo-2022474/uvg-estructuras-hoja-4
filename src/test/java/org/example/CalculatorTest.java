package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testSimpleAddition() {
        Main calculator = new Main();
        assertEquals(3.0, calculator.operate("1 + 2"), 0.0001);
    }

    @Test
    public void testSimpleSubtraction() {
        Main calculator = new Main();
        assertEquals(2.0, calculator.operate("5 - 3"), 0.0001);
    }

    @Test
    public void testSimpleMultiplication() {
        Main calculator = new Main();
        assertEquals(20.0, calculator.operate("4 * 5"), 0.0001);
    }

    @Test
    public void testSimpleDivision() {
        Main calculator = new Main();
        assertEquals(5.0, calculator.operate("10 / 2"), 0.0001);
    }

    @Test
    public void testParenthesesAddThenMultiply() {
        // (5 + 3) * 2 = 16
        Main calculator = new Main();
        assertEquals(16.0, calculator.operate("(5 + 3) * 2"), 0.0001);
    }

    @Test
    public void testParenthesesSubtractThenDivide() {
        // (10 - 2) / 4 = 2
        Main calculator = new Main();
        assertEquals(2.0, calculator.operate("(10 - 2) / 4"), 0.0001);
    }

    @Test
    public void testOperatorPrecedence() {
        // 1 + 2 * 3 = 7 (not 9)
        Main calculator = new Main();
        assertEquals(7.0, calculator.operate("1 + 2 * 3"), 0.0001);
    }

    @Test
    public void testDecimalNumbers() {
        Main calculator = new Main();
        assertEquals(6.0, calculator.operate("2.5 + 3.5"), 0.0001);
    }

    @Test
    public void testNegativeResult() {
        Main calculator = new Main();
        assertEquals(-2.0, calculator.operate("3 - 5"), 0.0001);
    }

    @Test
    public void testMultiDigitNumbers() {
        // (10+20)*9 = 270
        Main calculator = new Main();
        assertEquals(270.0, calculator.operate("(10+20)*9"), 0.0001);
    }

    @Test
    public void testComplexExpression() {
        // 3 + 4 * 2 - 1 = 3 + 8 - 1 = 10
        Main calculator = new Main();
        assertEquals(10.0, calculator.operate("3 + 4 * 2 - 1"), 0.0001);
    }

    @Test
    public void testNotEnoughOperands() {
        Main calculator = new Main();
        assertThrows(Exception.class, () -> calculator.operate("1 +"));
    }

    @Test
    public void testWithStackArray() {
        Main calculator = new Main(2, 1);
        assertEquals(270.0, calculator.operate("(10+20)*9"), 0.0001);
    }

    @Test
    public void testWithStackLinkedListSingly() {
        Main calculator = new Main(3, 1);
        assertEquals(270.0, calculator.operate("(10+20)*9"), 0.0001);
    }

    @Test
    public void testWithStackLinkedListDoubly() {
        Main calculator = new Main(3, 2);
        assertEquals(270.0, calculator.operate("(10+20)*9"), 0.0001);
    }
}
