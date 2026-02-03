package org.example;

import java.util.List;

public class Main implements Calc {
    public static void main(String[] args) {
        double value = new Main().operate("1 2 +");
        System.out.println(value);
    }

    @Override
    public double operate(String input) {
        List<Token> tokens = new Parser().parse(input);
        return new Calculator().operate(tokens);
    }
}