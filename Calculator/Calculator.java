package Calculator;

import java.util.*;

/**
 * Interface defining the contract for arithmetic operations
 * Demonstrates interface and polymorphism
 */
interface Operate {
    Double getResult(Double... numbers);
}

/**
 * Add class implementing Operate interface for addition
 */
class Add implements Operate {
    @Override
    public Double getResult(Double... numbers) {
        Double sum = 0.0;
        for (Double num : numbers) {
            sum += num;
        }
        return sum;
    }
}

/**
 * Subtract class implementing Operate interface for subtraction
 */
class Subtract implements Operate {
    @Override
    public Double getResult(Double... numbers) {
        Double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }
}

/**
 * Multiply class implementing Operate interface for multiplication
 */
class Multiply implements Operate {
    @Override
    public Double getResult(Double... numbers) {
        Double result = 1.0;
        for (Double num : numbers) {
            result *= num;
        }
        return result;
    }
}

/**
 * Divide class implementing Operate interface for division
 * Includes error handling for division by zero
 */
class Divide implements Operate {
    @Override
    public Double getResult(Double... numbers) {
        Double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                result /= numbers[i];
            } else {
                System.out.println("Error: Division by zero!");
                return null;
            }
        }
        return result;
    }
}

/**
 * Main Calculator class demonstrating interfaces and polymorphism
 */
public class Calculator {
    public static void main(String[] args) {
        System.out.println("Enter an expression (e.g., 4 + 5 * 3 / 2):");
        String input = new Scanner(System.in).nextLine();
        
        // Split input into numbers and operators using regex
        String[] numbers = input.split("[+\\-*/]");
        String[] operators = input.split("[0-9. ]+");
        
        // Convert to queues for processing
        Queue<Double> numberQueue = new LinkedList<>();
        Queue<String> operatorQueue = new LinkedList<>();
        
        // Parse numbers and add to queue
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                numberQueue.add(Double.parseDouble(number.trim()));
            }
        }
        
        // Parse operators and add to queue
        for (String operator : operators) {
            if (!operator.trim().isEmpty()) {
                operatorQueue.add(operator.trim());
            }
        }
        
        // Initialize result with first number
        Double result = numberQueue.poll();
        
        // Process each operator and number in sequence
        while (!numberQueue.isEmpty()) {
            String operator = operatorQueue.poll();
            Double nextNumber = numberQueue.poll();
            
            Operate operation;
            // Use polymorphism to determine the correct operation
            switch (operator) {
                case "+":
                    operation = new Add();
                    break;
                case "-":
                    operation = new Subtract();
                    break;
                case "*":
                    operation = new Multiply();
                    break;
                case "/":
                    operation = new Divide();
                    break;
                default:
                    System.out.println("Invalid operator: " + operator);
                    return;
            }
            
            // Perform the operation and update result
            result = operation.getResult(result, nextNumber);
            if (result == null) return; // Handle division by zero error
        }
        
        System.out.println("Result: " + result);
    }
}
