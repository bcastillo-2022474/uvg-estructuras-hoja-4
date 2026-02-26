package org.example;

import org.example.calc.Calculator;
import org.example.factory.StackFactory;
import org.example.parser.InfixParser;
import org.example.parser.Parser;
import org.example.parser.Token;
import org.example.stack.Stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements Calc {
    private int stackType = 1;  // 1=ArrayList, 2=Array, 3=LinkedList
    private int listType = 1;   // 1=singly linked, 2=doubly linked

    public Main() {}

    public Main(int stackType, int listType) {
        this.stackType = stackType;
        this.listType = listType;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la implementación de pila:");
        System.out.println("1. ArrayList");
        System.out.println("2. Array (Vector)");
        System.out.println("3. Lista enlazada");
        System.out.print("Opción: ");

        int stackChoice = readInt(scanner, 1);

        int listChoice = 1;
        if (stackChoice == 3) {
            System.out.println("Seleccione la implementación de lista:");
            System.out.println("1. Simplemente encadenada");
            System.out.println("2. Doblemente encadenada");
            System.out.print("Opción: ");
            listChoice = readInt(scanner, 1);
        }

        Main calc = new Main(stackChoice, listChoice);

        switch (stackChoice) {
            case 2: System.out.println("Usando StackArray."); break;
            case 3: System.out.println("Usando StackLinkedList con lista " + (listChoice == 2 ? "doblemente" : "simplemente") + " encadenada."); break;
            default: System.out.println("Usando StackArrayList.");
        }

        calc.processFile("datos.txt");
    }

    private static int readInt(Scanner scanner, int defaultValue) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * Reads a file and evaluates each infix expression line.
     */
    public void processFile(String filename) {
        List<String> lines = readFile(filename);
        if (lines == null) return;

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (!line.isEmpty()) {
                try {
                    double result = operate(line);
                    System.out.println("Línea " + (i + 1) + ": " + line + " = " + result);
                } catch (Exception e) {
                    System.out.println("Línea " + (i + 1) + ": " + line + " - Error: " + e.getMessage());
                }
            }
        }
    }

    public List<String> readFile(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }
            return lines;
        } catch (IOException e) {
            System.out.println("Error leyendo archivo '" + filename + "': " + e.getMessage());
            return null;
        }
    }

    /**
     * Evaluates an infix expression using the configured stack implementation.
     * Uses the InfixParser to convert to postfix first, then the Calculator singleton.
     */
    @Override
    public double operate(String input) {
        String postfix = new InfixParser().toPostfix(input);
        List<Token> tokens = new Parser().parse(postfix);
        Stack<Token> freshStack = StackFactory.createStack(stackType, listType);
        return Calculator.getInstance().operate(tokens, freshStack);
    }
}
