package ATM_Proj;

import java.util.Scanner;


public class Account {
    // Private fields (encapsulation)
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
    
    Scanner input = new Scanner(System.in);
    
    // Setter and getter methods for customer number
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }
    
    public int getCustomerNumber() {
        return customerNumber;
    }
    
    // Setter and getter methods for PIN
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }
    
    public int getPinNumber() {
        return pinNumber;
    }
    
    // Getter methods for balances
    public double getCheckingBalance() {
        return checkingBalance;
    }
    
    public double getSavingBalance() {
        return savingBalance;
    }
    
    // Methods to calculate new balances after transactions
    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }
    
    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }
    
    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }
    
    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }
    
    /**
     * Method to handle checking account withdrawal with input validation
     */
    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + getCheckingBalance());
        System.out.print("Amount you want to withdraw: ");
        double amount = input.nextDouble();
        
        // Validate that withdrawal won't result in negative balance
        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + checkingBalance);
        } else {
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }
    
    /**
     * Method to handle savings account withdrawal with input validation
     */
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + getSavingBalance());
        System.out.print("Amount you want to withdraw: ");
        double amount = input.nextDouble();
        
        // Validate that withdrawal won't result in negative balance
        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + savingBalance + "\n");
        } else {
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }
    
    /**
     * Method to handle checking account deposit with input validation
     */
    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + getCheckingBalance());
        System.out.print("Amount you want to deposit: ");
        double amount = input.nextDouble();
        
        // Validate that deposit won't result in invalid balance
        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + checkingBalance + "\n");
        } else {
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }
    
    /**
     * Method to handle savings account deposit with input validation
     */
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + getSavingBalance());
        System.out.print("Amount you want to deposit: ");
        double amount = input.nextDouble();
        
        // Validate that deposit won't result in invalid balance
        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + savingBalance + "\n");
        } else {
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }
}