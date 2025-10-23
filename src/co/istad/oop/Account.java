package co.istad.oop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Account {
    private String accountNumber;
    private String accountName;
    private BigDecimal balance;
    private LocalDate createdAt;

    public Account() {
    }

    public Account(String accountNumber, String accountName, BigDecimal balance, LocalDate createdAt) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Amount must be greater than zero");
            return;
        }
        balance = balance.add(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Amount must be greater than zero");
            return;
        }
        if (amount.compareTo(balance) > 0) {
            System.out.println("Insufficient balance. Your current balance is $" + balance);
            return;
        }
        balance = balance.subtract(amount).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Withdrawal successful: $" + amount.setScale(2, RoundingMode.HALF_UP));
    }

    public void checkBalance() {
        System.out.println("========================================");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: " + balance);
        System.out.println("Created At: " + createdAt);
        System.out.println("Account Type: " + this.getClass().getSimpleName());
    }
}
