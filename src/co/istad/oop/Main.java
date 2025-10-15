package co.istad.oop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Card card = new Card(1234, BigDecimal.valueOf(10000), LocalDate.of(2026, 1, 1));
        PayrollAccount payrollAccount = new PayrollAccount(
                "987654321",
                "Piseth Payroll",
                BigDecimal.valueOf(10000),
                LocalDate.now(),
                BigDecimal.valueOf(0.10)
        );
        SavingAccount savingAccount = new SavingAccount(
                "123456789",
                "Piseth Mao",
                BigDecimal.valueOf(10000),
                LocalDate.now(),
                BigDecimal.valueOf(0.05),
                card
        );
//        savingAccount.accountNumber = "123456789";
//        savingAccount.accountName = "Piseth Mao";
//        savingAccount.balance = BigDecimal.valueOf(10000);
//        savingAccount.createdAt = LocalDate.now();
//        savingAccount.createdAt = LocalDate.of(2020, 1, 1);
//        savingAccount.interestRate = BigDecimal.valueOf(0.05);
        do {
            System.out.println("Welcome to the Saving Account Management System");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Payroll Account");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("Depositing...");
                    System.out.print("Enter the amount to deposit: ");
                    double amount = Double.parseDouble(input.nextLine());
                    System.out.print("Enter the PIN: ");
                    int enteredPin = Integer.parseInt(input.nextLine());
                    savingAccount.deposit(BigDecimal.valueOf(amount), enteredPin);
                }
                case 2 -> {
                    System.out.println("Withdrawing...");
                    System.out.print("Enter the amount to withdraw: ");
                    double amount2 = Double.parseDouble(input.nextLine());
                    System.out.print("Enter the PIN: ");
                    int enteredPin2 = Integer.parseInt(input.nextLine());
                    savingAccount.withdraw(BigDecimal.valueOf(amount2), enteredPin2);
                }
                case 3 -> {
                    System.out.print("Entering gross salary: ");
                    double salary = Double.parseDouble(input.nextLine());
                    payrollAccount.calculateTax(BigDecimal.valueOf(salary));
                }
                case 4 -> {
                    savingAccount.checkBalance();
                    payrollAccount.checkBalance();
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        } while (true);
    }
}
