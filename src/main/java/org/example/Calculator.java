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

        System.out.println(stack);

        if (tokens.getFirst().type.equals("OPERATOR")) {
            throw new RuntimeException("Operator was defined but not enough operants were given");
        }

        if (tokens.size() > 1) {
            throw new RuntimeException("Operator was given but not enough operators were given");
        }

        return Double.parseDouble(tokens.getFirst().value);
    }
}

