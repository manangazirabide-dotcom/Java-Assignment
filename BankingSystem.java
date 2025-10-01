package javaassignment;

import java.io.FileWriter;
import java.io.IOException;

abstract class Bank {
    protected String accountName;
    protected double balance;
    
    public Bank(String accountName, double initialBalance) {
        this.accountName = accountName;
        this.balance = initialBalance;
    }
    
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract double getBalance();
    
    protected void recordTransaction(String transaction) {
        try {
            FileWriter writer = new FileWriter("Bank.txt", true);
            writer.write(transaction + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error recording transaction: " + e.getMessage());
        }
    }
}

class Account extends Bank {
    public Account(String accountName, double initialBalance) {
        super(accountName, initialBalance);
        recordTransaction("Account created: " + accountName + " with initial balance: $" + initialBalance);
    }
    
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            recordTransaction("Deposited: $" + amount + " to " + accountName + ". New balance: $" + balance);
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Withdrawal amount exceeded account balance");
            recordTransaction("Failed withdrawal attempt: $" + amount + " from " + accountName + ". Insufficient funds.");
        } else if (amount > 0) {
            balance -= amount;
            recordTransaction("Withdrew: $" + amount + " from " + accountName + ". New balance: $" + balance);
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
    
    @Override
    public double getBalance() {
        recordTransaction("Balance checked for " + accountName + ": $" + balance);
        return balance;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        System.out.println("=== TASK 1: BANKING SYSTEM ===");
        Account myAccount = new Account("John Doe", 1000.0);
        
        myAccount.deposit(500.0);  // 500 will be deposited 
        myAccount.withdraw(200.0); // 200 will be withdrawn here
        myAccount.withdraw(2000.0); // 2000 can't be withdrawn,results in an error
        myAccount.deposit(-100.0);  // 	Invalid amount to deposit,a negative value
        
        System.out.println("Current balance: $" + myAccount.getBalance()); //show the balance after successfully withdrawing 200 and depositing 500
    }
}