package com.tana.tutorial;

import java.util.Scanner;

/**
 * CONTROL FLOW CONCEPTS
 * 
 * Comparison Operators: Used to compare values
 * Logical Operators: Combine multiple conditions
 * Conditional Statements: Make decisions in code
 * Loops: Execute code repeatedly
 */
public class ControlFlow {

    public static void main(String[] args) {
        // 1. COMPARISON OPERATORS
        int x = 5;
        int y = 10;
        boolean isEqual = (x == y);      // false
        boolean isNotEqual = (x != y);   // true
        boolean isGreater = (x > y);     // false
        boolean isLessOrEqual = (x <= y); // true

        // 2. LOGICAL OPERATORS
        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
        // true because both conditions in parentheses are true AND criminal record is false

        // 3. IF STATEMENTS
        int temperature = 32;
        
        if (temperature > 30) {
            System.out.println("It's a hot day");
            System.out.println("Drink plenty of water");
        } else if (temperature > 20) {
            System.out.println("Beautiful day");
        } else {
            System.out.println("Cold day");
        }

        // 4. SIMPLIFYING IF STATEMENTS
        int income = 120_000;
        boolean hasHighIncome2 = (income > 100_000); // Simplified boolean expression

        // 5. TERNARY OPERATOR
        String className = income > 100_000 ? "First Class" : "Economy";
        // If income > 100000, className is "First Class", else "Economy"

        // 6. SWITCH STATEMENTS
        String role = "admin";
        
        switch (role) {
            case "admin":
                System.out.println("You're an admin");
                break;
            case "moderator":
                System.out.println("You're a moderator");
                break;
            default:
                System.out.println("You're a guest");
        }

        // 7. FIZZBUZZ EXERCISE SOLUTION
        int number = 15;
        
        if (number % 5 == 0 && number % 3 == 0)
            System.out.println("FizzBuzz");
        else if (number % 5 == 0)
            System.out.println("Fizz");
        else if (number % 3 == 0)
            System.out.println("Buzz");
        else
            System.out.println(number);

        // 8. FOR LOOPS
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World " + i);
        }
        
        // Reverse loop
        for (int i = 5; i > 0; i--) {
            System.out.println("Countdown: " + i);
        }

        // 9. WHILE LOOPS
        int count = 5;
        while (count > 0) {
            System.out.println("While count: " + count);
            count--;
        }

        // 10. DO-WHILE LOOPS (executes at least once)
        int i = 5;
        do {
            System.out.println("Do-while: " + i);
            i--;
        } while (i > 0);

        // 11. BREAK AND CONTINUE
        Scanner scanner = new Scanner(System.in);
        String input = "";
        
        while (true) {
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass"))
                continue; // Skip to next iteration
            if (input.equals("quit"))
                break; // Exit loop
            System.out.println(input);
        }

        // 12. FOR-EACH LOOP
        String[] fruits = {"Apple", "Mango", "Orange"};
        
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
