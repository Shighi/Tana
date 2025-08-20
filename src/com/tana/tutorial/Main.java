// 1. BASIC PROGRAM STRUCTURE
package com.tana.tutorial; // Package declaration

// Required imports (all at the top)
import java.util.Date;
import java.util.Arrays;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main { // Class declaration (PascalCase)

    // Main method - entry point
    public static void main(String[] args) { // Method declaration
        System.out.println("Hello World"); // Statement

        // 2. VARIABLES
        int age = 30; // Declaration & initialization
        age = 35; // Reassignment
        int herAge = age; // Copying values

        // 3. PRIMITIVE TYPES
        byte viewsCount = 123; // 1 byte (-128 to 127)
        short smallNumber = 32000; // 2 bytes
        int largeNumber = 2_000_000_000; // 4 bytes (underscores for readability)
        long veryLarge = 3_000_000_000L; // 8 bytes (L suffix)
        float price = 10.99F; // 4 bytes (F suffix)
        char grade = 'A'; // 2 bytes
        boolean isValid = true; // 1 bit

        // 4. REFERENCE TYPES
        Date now = new Date(); // Requires 'new' keyword
        System.out.println(now.getTime()); // Methods accessible via dot operator

        // 5. STRINGS
        String message = "Hello" + " World!"; // Concatenation
        System.out.println(message.length()); // 12
        System.out.println(message.startsWith("Hello")); // true
        System.out.println(message.replace("!", "!!!")); // Returns new string

        // 6. ESCAPE SEQUENCES
        String path = "c:\\Windows\\..."; // Backslash
        String quote = "He said \"Hello\""; // Double quotes
        String multiLine = "Line1\nLine2"; // New line

        // 7. ARRAYS
        int[] numbers = new int[5]; // Declaration
        numbers[0] = 1;
        int[] initialized = { 2, 3, 5, 1, 4 }; // Shorthand
        Arrays.sort(initialized); // Sorting

        // 8. MULTI-DIMENSIONAL ARRAYS
        int[][] matrix = new int[2][3]; // 2 rows, 3 columns
        int[][] literal = { {1, 2, 3}, {4, 5, 6} };

        // 9. CONSTANTS
        final float PI = 3.14F; // Cannot be reassigned

        // 10. ARITHMETIC
        int result = 10 + 3 * 2; // Result: 16 (order of operations)
        result++; // Increment
        result += 2; // Compound assignment

        // 11. CASTING
        // Implicit (widening)
        double price2 = 10.99;
        int truncated = (int) price2; // Explicit narrowing (truncates to 10)

        // String to number
        String input = "123";
        int num = Integer.parseInt(input);

        // 12. MATH CLASS
        System.out.println(Math.round(1.1F)); // 1
        System.out.println(Math.ceil(1.1)); // 2.0
        System.out.println(Math.max(1, 2)); // 2
        double random = Math.random() * 100; // 0.0 to 99.9
        System.out.println(random);

        // 13. NUMBER FORMATTING
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String formatted = currency.format(1234567.891); // $1,234,567.89
        System.out.println(formatted);

        // 14. READING INPUT
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age: ");
        byte userAge = scanner.nextByte(); // Reads primitive types
        scanner.nextLine(); // Consume leftover newline
        System.out.print("Name: ");
        String name = scanner.nextLine().trim(); // Reads full line
        System.out.println("You entered: " + name + ", " + userAge);
    }
}
// PROJECT: Mortgage Calculator
// Instructions: Calculate monthly mortgage payment using:
// mortgage = P * r * (1 + r)^n / ((1 + r)^n - 1)
// Where:
// P = Principal amount
// r = Monthly interest rate (annual rate / 12 / 100)
// n = Number of payments (years * 12)

// SOLUTION
package com.tana.mortgagecalculator;
// Import Scanner for user input and NumberFormat for currency formatting
import java.util.Scanner;
import java.text.NumberFormat;

public class MortgageCalculator {
    public static void main(String[] args) {
        // Constants for conversion calculations
        final byte MONTHS_IN_YEAR = 12;  // Used to convert years to months
        final byte PERCENT = 100;        // Used to convert percentage to decimal

        // Create Scanner object to read user input from console
        Scanner scanner = new Scanner(System.in);

        // Get the principal loan amount from user
        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        // Get the annual interest rate as a percentage from user
        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();

        // Convert annual interest rate to monthly interest rate in decimal form
        // Formula: (annual rate / 100) / 12 months
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        // Get the loan period in years from user
        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();

        // Calculate total number of monthly payments
        int numberOfPayments = years * MONTHS_IN_YEAR;

        // Calculate monthly mortgage payment using the standard mortgage formula
        // mortgage = P * r * (1 + r)^n / ((1 + r)^n - 1)
        // Where P = principal, r = monthly interest rate, n = number of payments
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        // Format the mortgage payment as currency (with $ symbol and proper formatting)
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        // Display the calculated monthly mortgage payment
        System.out.println("Mortgage: " + formattedMortgage);
    }
}

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