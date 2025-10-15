package co.istad.oop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {
    String accountNumber;
    String accountName;
    BigDecimal balance;
    LocalDate createdAt;

    public Account() {
    }

    public Account(String accountNumber, String accountName, BigDecimal balance, LocalDate createdAt) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Amount must be greater than zero");
        }
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Amount must be greater than zero");
        }
        if (amount.compareTo(balance) > 0) {
            System.out.println("❌ Insufficient balance. Your current balance is $" + balance);
            return;
        }
        balance = balance.subtract(amount);
        System.out.println("Withdrawal successful: $" + amount);
    }

    public void checkBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: " + balance);
        System.out.println("Created At: " + createdAt);
        System.out.println("Account Type: " + this.getClass().getSimpleName());
    }
}
