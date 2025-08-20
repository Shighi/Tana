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
