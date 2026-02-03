package org.example;

import java.util.List;

public class Main implements Calc {
    public static void main(String[] args) {
        Main calc = new Main();
        System.out.println("1 2 + = " + calc.operate("1 2 +"));
        System.out.println("5 3 + 2 * = " + calc.operate("5 3 + 2 *"));
        System.out.println("10 2 - 4 / = " + calc.operate("10 2 - 4 /"));
    }

    @Override
    public double operate(String input) {
        List<Token> tokens = new Parser().parse(input);
        return new Calculator().operate(tokens);
    }
}