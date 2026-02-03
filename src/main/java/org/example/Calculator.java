package org.example;

import java.util.HashMap;
import java.util.List;


interface Operation {
    double operate(double a, double b);
}


public class Calculator {
    HashMap<String, Operation> operators = new HashMap<>() {{
        put("+", (a, b) -> {
            return a + b;
        });
        put("-", (a, b) -> {
            return a -b;
        });
        put("/", (a, b)-> {
         return a / b;
        });
        put("*", (a, b) -> {
            return a * b;
        });

    }};

    public double operate(List<Token> tokens) {
        Stack<Token> stack = new StackArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token.type.equals("OPERATOR")) {
                Token first = stack.pop();
                Token second = stack.pop();
                double newValue = operators.get(token.value).operate(Double.parseDouble(second.value), Double.parseDouble(first.value));
                stack.push(new Token("OPERAND", Double.toString(newValue)));
            }

            else if (token.type.equals("OPERAND")) {
                stack.push(token);
            }

        }

        Token result = stack.pop();

        try {
            stack.pop();
            throw new RuntimeException("Not enough operators were given");
        } catch (IllegalArgumentException e) {
            // Stack is empty, which is correct - we have exactly one result
        }

        return Double.parseDouble(result.value);
    }
}

