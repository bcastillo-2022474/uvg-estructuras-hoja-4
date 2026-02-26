package org.example.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Parses a string input into a list of tokens
 */
public class Parser {
    /**
     * Parses a postfix expression string into tokens
     * @param input Space-separated postfix expression
     * @return List of tokens (operands and operators)
     */
    public List<Token> parse(String input){
      String[]  values = input.split(" ");
        List<Token> tokens = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            Boolean isOperator = value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");

            Token token;
            if (isOperator) {
                token = new Token("OPERATOR", value);
            } else {
                try {
                    Double.parseDouble(value);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Carácter inválido: " + value);
                }
                token = new Token("OPERAND", value);
            }
            tokens.add(token);
        }
        return tokens;
    }
}
