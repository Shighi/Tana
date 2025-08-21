package ATM_Proj;

import java.io.IOException;

/**
 * Main ATM class that serves as the entry point for the application
 * Demonstrates inheritance (extends OptionMenu)
 */
public class ATM extends OptionMenu {
    /**
     * Main method - application entry point
     * @param args Command line arguments
     * @throws IOException if input/output error occurs
     */
    public static void main(String[] args) throws IOException {
        OptionMenu optionMenu = new OptionMenu();
        optionMenu.getLogin();
    }
}
