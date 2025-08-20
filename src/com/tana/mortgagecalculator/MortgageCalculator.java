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