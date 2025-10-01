package javaassignment;

// Custom exception class
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Main class
public class CustomException {
    public static void main(String[] args) {
        System.out.println("=== TASK 3: CUSTOM EXCEPTION ===");
        try {
            checkBalance(100, 500); // This will throw exception
        } catch (InsufficientFundsException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
        
        try {
            checkBalance(1000, 500); // This should work
        } catch (InsufficientFundsException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }
    
    public static void checkBalance(double balance, double withdrawalAmount) 
            throws InsufficientFundsException {
        if (withdrawalAmount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds! Balance: $" + balance + 
                ", Withdrawal attempt: $" + withdrawalAmount
            );
        } else {
            System.out.println("Withdrawal approved! Remaining balance: $" + (balance - withdrawalAmount));
        }
    }
}