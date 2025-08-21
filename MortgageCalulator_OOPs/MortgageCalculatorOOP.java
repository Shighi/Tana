package MortgageCalulator_OOPs;

import java.util.Scanner;
import java.text.NumberFormat;

/**
 * MortgageCalculator class responsible for mortgage calculations
 */
class MortgageCalculator {
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;
    
    private int principal;
    private float annualInterest;
    private byte years;
    
    /**
     * Constructor for MortgageCalculator
     */
    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }
    
    /**
     * Calculate monthly mortgage payment
     */
    public double calculateMortgage() {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;
        
        // Mortgage formula: M = P [ i(1+i)^n ] / [ (1+i)^n – 1]
        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
    
    /**
     * Calculate remaining balance after specified number of payments
     */
    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;
        
        // Balance formula: B = P [ (1+i)^n - (1+i)^p ] / [ (1+i)^n – 1]
        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
    
    /**
     * Get array of remaining balances for each payment period
     */
    public double[] getRemainingBalances() {
        double[] balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }
    
    /**
     * Get total number of payments
     */
    public int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
}

/**
 * MortgageInputHandler class responsible for handling user input
 */
class MortgageInputHandler {
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * Read and validate principal amount
     */
    public static int readPrincipal() {
        int principal;
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1,000 and 1,000,000.");
        }
        return principal;
    }
    
    /**
     * Read and validate annual interest rate
     */
    public static float readAnnualInterest() {
        float annualInterest;
        while (true) {
            System.out.print("Annual Interest Rate (1-30): ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30)
                break;
            System.out.println("Enter a value between 1 and 30.");
        }
        return annualInterest;
    }
    
    /**
     * Read and validate loan period
     */
    public static byte readYears() {
        byte years;
        while (true) {
            System.out.print("Period (Years 1-30): ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30)
                break;
            System.out.println("Enter a value between 1 and 30.");
        }
        return years;
    }
}

/**
 * Main class for Mortgage Calculator application
 * Demonstrates OOP principles and application structure
 */
public class MortgageCalculatorOOP {
    public static void main(String[] args) {
        // Get user input with validation
        int principal = MortgageInputHandler.readPrincipal();
        float annualInterest = MortgageInputHandler.readAnnualInterest();
        byte years = MortgageInputHandler.readYears();
        
        // Create calculator instance
        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterest, years);
        
        // Calculate and display mortgage
        double mortgage = calculator.calculateMortgage();
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
        
        // Display payment schedule
        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        double[] balances = calculator.getRemainingBalances();
        for (short month = 1; month <= balances.length; month++) {
            System.out.println(NumberFormat.getCurrencyInstance().format(balances[month - 1]));
        }
    }
}
