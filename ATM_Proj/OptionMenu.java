package ATM_Proj;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * OptionMenu class extending Account
 * Demonstrates inheritance and menu-driven program design
 */
public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    
    /**
     * Method to handle user login with validation
     * @throws IOException if input/output error occurs
     */
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                // Predefined customer number and PIN combinations
                data.put(952141, 191904);
                data.put(989947, 71976);
                
                System.out.println("Welcome to the ATM Project!");
                System.out.print("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());
                
                System.out.print("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                x = 2;
            }
            
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            
            // Validate customer number and PIN
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
        } while (x == 1);
    }
    
    /**
     * Method to display account type selection menu
     */
    public void getAccountType() {
        System.out.println("Select the Account you Want to Access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice: ");
        
        int selection = menuInput.nextInt();
        
        // Switch case for account selection
        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }
    
    /**
     * Method to display checking account operations menu
     */
    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");
        
        int selection = menuInput.nextInt();
        
        // Switch case for checking account operations
        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + getCheckingBalance() + "\n");
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getChecking();
        }
    }
    
    /**
     * Method to display savings account operations menu
     */
    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");
        
        int selection = menuInput.nextInt();
        
        // Switch case for savings account operations
        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + getSavingBalance() + "\n");
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getSaving();
        }
    }
}
