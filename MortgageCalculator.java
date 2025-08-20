//ENHANCED MORTGAGE CALCULATOR WITH COMPREHENSIVE INPUT VALIDATION


import java.util.Scanner;
import java.text.NumberFormat;
import java.util.InputMismatchException;

public class MortgageCalculator {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        
        // Declare variables outside of loops to avoid scope issues
        int principal = 0;
        float annualInterest = 0;
        float monthlyInterest = 0;
        byte years = 0;
        int numberOfPayments = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== MORTGAGE CALCULATOR ===\n");
        
        // Validate principal input with enhanced feedback
        while (true) {
            System.out.print("Principal ($1,000 - $1,000,000): $");
            try {
                principal = scanner.nextInt();
                if (principal >= 1000 && principal <= 1_000_000) {
                    break;
                } else if (principal < 1000) {
                    System.out.println("Principal too low! Please enter at least $1,000");
                } else {
                    System.out.println("Principal too high! Please enter no more than $1,000,000");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a whole number (e.g., 250000 for $250,000)");
                scanner.next(); // Clear the invalid input
            }
            System.out.println("Example: Enter '250000' for $250,000\n");
        }
        
        // Validate annual interest rate input with enhanced feedback
        while (true) {
            System.out.print("Annual Interest Rate (1% - 30%): ");
            try {
                annualInterest = scanner.nextFloat();
                if (annualInterest >= 1 && annualInterest <= 30) {
                    monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                    break;
                } else if (annualInterest < 1) {
                    System.out.println("Interest rate too low! Please enter at least 1%");
                } else {
                    System.out.println("Interest rate too high! Please enter no more than 30%");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 30");
                scanner.next(); // Clear the invalid input
            }
            System.out.println("Example: Enter '4.5' for 4.5% annual interest\n");
        }
        
        // Validate years input with enhanced feedback
        while (true) {
            System.out.print("Loan Period (1 - 30 years): ");
            try {
                years = scanner.nextByte();
                if (years >= 1 && years <= 30) {
                    numberOfPayments = years * MONTHS_IN_YEAR;
                    break;
                } else if (years < 1) {
                    System.out.println("Loan period too short! Please enter at least 1 year");
                } else {
                    System.out.println("Loan period too long! Please enter no more than 30 years");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a whole number between 1 and 30");
                scanner.next(); // Clear the invalid input
            }
            System.out.println("   Example: Enter '15' for a 15-year mortgage\n");
        }
        
        // Calculate mortgage using the mortgage formula
        double mortgage = principal 
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        
        // Display results with summary
        System.out.println("\n" + "=".repeat(40));
        System.out.println("MORTGAGE CALCULATION RESULTS");
        System.out.println("=".repeat(40));
        System.out.printf("Principal Amount: %s%n", NumberFormat.getCurrencyInstance().format(principal));
        System.out.printf("Annual Interest Rate: %.2f%%%n", annualInterest);
        System.out.printf("Loan Period: %d years (%d payments)%n", years, numberOfPayments);
        System.out.println("-".repeat(40));
        System.out.printf("Monthly Payment: %s%n", NumberFormat.getCurrencyInstance().format(mortgage));
        System.out.printf("Total Amount Paid: %s%n", NumberFormat.getCurrencyInstance().format(mortgage * numberOfPayments));
        System.out.printf("Total Interest Paid: %s%n", NumberFormat.getCurrencyInstance().format((mortgage * numberOfPayments) - principal));
        System.out.println("=".repeat(40));
        
        // Close scanner to prevent resource leak
        scanner.close();
    }
}