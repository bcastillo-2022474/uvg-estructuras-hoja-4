package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testSimpleAddition() {
        Main calculator = new Main();
        double result = calculator.operate("1 2 +");
        assertEquals(3.0, result, 0.0001);
    }

    @Test
    public void testSimpleSubtraction() {
        Main calculator = new Main();
        double result = calculator.operate("5 3 -");
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testSimpleMultiplication() {
        Main calculator = new Main();
        double result = calculator.operate("4 5 *");
        assertEquals(20.0, result, 0.0001);
    }

    @Test
    public void testSimpleDivision() {
        Main calculator = new Main();
        double result = calculator.operate("10 2 /");
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testComplexExpression() {
        Main calculator = new Main();
        // (5 + 3) * 2 = 8 * 2 = 16
        double result = calculator.operate("5 3 + 2 *");
        assertEquals(16.0, result, 0.0001);
    }

    @Test
    public void testAnotherComplexExpression() {
        Main calculator = new Main();
        // (10 - 2) / 4 = 8 / 4 = 2
        double result = calculator.operate("10 2 - 4 /");
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testMultipleOperations() {
        Main calculator = new Main();
        // 1 + 2 - 3 = 3 - 3 = 0
        double result = calculator.operate("1 2 + 3 -");
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testDecimalNumbers() {
        Main calculator = new Main();
        double result = calculator.operate("2.5 3.5 +");
        assertEquals(6.0, result, 0.0001);
    }

    @Test
    public void testNegativeResult() {
        Main calculator = new Main();
        double result = calculator.operate("3 5 -");
        assertEquals(-2.0, result, 0.0001);
    }

    @Test
    public void testNotEnoughOperators() {
        Main calculator = new Main();
        assertThrows(RuntimeException.class, () -> {
            calculator.operate("1 2 3 +");
        });
    }

    @Test
    public void testNotEnoughOperands() {
        Main calculator = new Main();
        assertThrows(Exception.class, () -> {
            calculator.operate("1 +");
        });
    }
}
