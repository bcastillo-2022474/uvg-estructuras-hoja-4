package org.example;

import org.example.parser.Parser;
import org.example.parser.Token;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void testParseSimpleExpression() {
        Parser parser = new Parser();
        List<Token> tokens = parser.parse("1 2 +");

        assertEquals(3, tokens.size());
        assertEquals("OPERAND", tokens.get(0).type);
        assertEquals("1", tokens.get(0).value);
        assertEquals("OPERAND", tokens.get(1).type);
        assertEquals("2", tokens.get(1).value);
        assertEquals("OPERATOR", tokens.get(2).type);
        assertEquals("+", tokens.get(2).value);
    }

    @Test
    public void testParseMultipleOperators() {
        Parser parser = new Parser();
        List<Token> tokens = parser.parse("5 3 + 2 *");

        assertEquals(5, tokens.size());
        assertEquals("OPERAND", tokens.get(0).type);
        assertEquals("OPERATOR", tokens.get(2).type);
        assertEquals("OPERAND", tokens.get(3).type);
        assertEquals("OPERATOR", tokens.get(4).type);
    }

    @Test
    public void testParseAllOperators() {
        Parser parser = new Parser();
        List<Token> tokens = parser.parse("+ - * /");

        assertEquals(4, tokens.size());
        for (Token token : tokens) {
            assertEquals("OPERATOR", token.type);
        }
    }

    @Test
    public void testParseDecimalNumbers() {
        Parser parser = new Parser();
        List<Token> tokens = parser.parse("2.5 3.5 +");

        assertEquals("OPERAND", tokens.get(0).type);
        assertEquals("2.5", tokens.get(0).value);
        assertEquals("OPERAND", tokens.get(1).type);
        assertEquals("3.5", tokens.get(1).value);
    }
}
