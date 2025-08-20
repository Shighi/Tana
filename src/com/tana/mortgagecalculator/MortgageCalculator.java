package com.tana.mortgagecalculator;

import java.util.Scanner;
import java.text.NumberFormat;

public class MortgageCalculator {
    public static void main(String[] args) {
        // Using byte for constants saves memory and prevents magic numbers
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        
        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        
        // Convert annual percentage to monthly decimal rate
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        
        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        
        // Total monthly payments over loan term
        int numberOfPayments = years * MONTHS_IN_YEAR;
        
        // Apply mortgage formula: P * r * (1 + r)^n / ((1 + r)^n - 1)
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        
        // Format result as currency
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formattedMortgage);
        
        scanner.close();
    }
}