package org.example;

import org.example.parser.InfixParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InfixParserTest {

    @Test
    public void testSimpleAddition() {
        InfixParser parser = new InfixParser();
        assertEquals("1 2 +", parser.toPostfix("1+2"));
    }

    @Test
    public void testSimpleSubtraction() {
        InfixParser parser = new InfixParser();
        assertEquals("5 3 -", parser.toPostfix("5-3"));
    }

    @Test
    public void testMultiplicationBeforeAddition() {
        // 1+2*9 → postfix: 1 2 9 * +
        InfixParser parser = new InfixParser();
        assertEquals("1 2 9 * +", parser.toPostfix("1+2*9"));
    }

    @Test
    public void testParenthesesOverridePrecedence() {
        // (1+2)*9 → postfix: 1 2 + 9 *
        InfixParser parser = new InfixParser();
        assertEquals("1 2 + 9 *", parser.toPostfix("(1+2)*9"));
    }

    @Test
    public void testMultiDigitNumbers() {
        // (10+20)*9 → postfix: 10 20 + 9 *
        InfixParser parser = new InfixParser();
        assertEquals("10 20 + 9 *", parser.toPostfix("(10+20)*9"));
    }

    @Test
    public void testSpacesAreIgnored() {
        InfixParser parser = new InfixParser();
        assertEquals("10 20 + 9 *", parser.toPostfix("( 10 + 20 ) * 9"));
    }

    @Test
    public void testNestedParentheses() {
        // ((2+3)*4) → 2 3 + 4 *
        InfixParser parser = new InfixParser();
        assertEquals("2 3 + 4 *", parser.toPostfix("((2+3)*4)"));
    }

    @Test
    public void testOperatorPrecedenceMixedOps() {
        // 3+4*2-1 → 3 4 2 * + 1 -
        InfixParser parser = new InfixParser();
        assertEquals("3 4 2 * + 1 -", parser.toPostfix("3+4*2-1"));
    }

    @Test
    public void testDivision() {
        // 10/2 → 10 2 /
        InfixParser parser = new InfixParser();
        assertEquals("10 2 /", parser.toPostfix("10/2"));
    }

    @Test
    public void testComplexExpression() {
        // (5+3)*(2-1) → 5 3 + 2 1 - *
        InfixParser parser = new InfixParser();
        assertEquals("5 3 + 2 1 - *", parser.toPostfix("(5+3)*(2-1)"));
    }

    @Test
    public void testDecimalNumbers() {
        // 2.5+3.5 → 2.5 3.5 +
        InfixParser parser = new InfixParser();
        assertEquals("2.5 3.5 +", parser.toPostfix("2.5+3.5"));
    }

    @Test
    public void testSingleNumber() {
        InfixParser parser = new InfixParser();
        assertEquals("42", parser.toPostfix("42"));
    }

    @Test
    public void testLeftAssociativitySubtraction() {
        // 10-3-2 should be (10-3)-2 = 10 3 - 2 -
        InfixParser parser = new InfixParser();
        assertEquals("10 3 - 2 -", parser.toPostfix("10-3-2"));
    }
}
