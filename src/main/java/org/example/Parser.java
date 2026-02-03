package org.example;

import java.util.ArrayList;
import java.util.List;

public class Parser {
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
                token = new Token("OPERAND", value);
            }
            tokens.add(token);
        }
        return tokens;
    }
}
