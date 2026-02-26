package org.example.calc;

import org.example.stack.Stack;
import org.example.parser.Token;

import java.util.HashMap;
import java.util.List;

/**
 * Functional interface for binary operations
 */
interface Operation {
    double operate(double a, double b);
}

/**
 * Singleton calculator that evaluates postfix expressions using a stack.
 */
public class Calculator {
    private static Calculator instance;

    private final HashMap<String, Operation> operators = new HashMap<>() {{
        put("+", (a, b) -> a + b);
        put("-", (a, b) -> a - b);
        put("/", (a, b) -> {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        });
        put("*", (a, b) -> a * b);
    }};

    private Calculator() {}

    /**
     * Returns the single instance of Calculator (Singleton pattern).
     */
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    /**
     * Evaluates a list of tokens in postfix notation using the provided stack.
     * @param tokens List of tokens representing a postfix expression
     * @param stack  Fresh stack to use for evaluation
     * @return Result of the evaluation
     */
    public double operate(List<Token> tokens, Stack<Token> stack) {
        for (Token token : tokens) {
            if (token.type.equals("OPERATOR")) {
                try {
                    Token first = stack.pop();
                    Token second = stack.pop();
                    double newValue = operators.get(token.value)
                            .operate(Double.parseDouble(second.value), Double.parseDouble(first.value));
                    stack.push(new Token("OPERAND", Double.toString(newValue)));
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("Falta de operandos para el operador: " + token.value);
                }
            } else if (token.type.equals("OPERAND")) {
                stack.push(token);
            }
        }

        Token result = stack.pop();

        try {
            stack.pop();
            throw new RuntimeException("Error: La expresión tiene operandos de más.");
        } catch (IllegalArgumentException e) {
            // Stack is empty — exactly one result, as expected
        }

        return Double.parseDouble(result.value);
    }
}
