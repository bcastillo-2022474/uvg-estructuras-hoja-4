package org.example.parser;

import org.example.stack.Stack;
import org.example.stack.StackArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts an infix expression string to postfix (Reverse Polish Notation).
 * Supports +, -, *, / operators and parentheses with multi-digit numbers.
 */
public class InfixParser {

    private int precedence(String op) {
        switch (op) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            default: return 0;
        }
    }

    /**
     * Converts an infix expression to a postfix expression string.
     * @param infix The infix expression (e.g. "(10+20)*9")
     * @return The postfix expression (e.g. "10 20 + 9 *")
     */
    public String toPostfix(String infix) {
        Stack<String> opStack = new StackArrayList<>();
        opStack.push("#");

        StringBuilder output = new StringBuilder();
        List<String> tokens = tokenize(infix);

        for (String token : tokens) {
            if (isNumber(token)) {
                if (output.length() > 0) output.append(" ");
                output.append(token);

            } else if (token.equals("(")) {
                opStack.push(token);

            } else if (token.equals(")")) {
                while (!opStack.peek().equals("#") && !opStack.peek().equals("(")) {
                    output.append(" ").append(opStack.pop());
                }
                if (!opStack.peek().equals("#")) {
                    opStack.pop(); // discard the "("
                }

            } else {
                // Operator: pop while top has >= precedence
                while (!opStack.peek().equals("#")
                        && !opStack.peek().equals("(")
                        && precedence(token) <= precedence(opStack.peek())) {
                    output.append(" ").append(opStack.pop());
                }
                opStack.push(token);
            }
        }

        // Flush remaining operators
        while (!opStack.peek().equals("#")) {
            output.append(" ").append(opStack.pop());
        }

        return output.toString().trim();
    }

    /**
     * Splits an infix expression into a list of token strings (numbers and symbols).
     */
    private List<String> tokenize(String infix) {
        List<String> tokens = new ArrayList<>();
        String clean = infix.replaceAll("\\s+", "");
        int i = 0;
        while (i < clean.length()) {
            char ch = clean.charAt(i);
            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder num = new StringBuilder();
                while (i < clean.length() && (Character.isDigit(clean.charAt(i)) || clean.charAt(i) == '.')) {
                    num.append(clean.charAt(i));
                    i++;
                }
                tokens.add(num.toString());
            } else {
                tokens.add(String.valueOf(ch));
                i++;
            }
        }
        return tokens;
    }

    private boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
