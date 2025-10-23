package co.istad.oop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Card card = new Card();
        card.setCardNumber("123456789");
        card.setCsv(10000);
        card.setPin("1234");
        card.setOverLimit(BigDecimal.valueOf(10000));
        card.setCardType("VISA");
        card.setCreatedAt(LocalDate.now());
        card.setExpiredAt(LocalDate.now().plusYears(1));
        SavingAccount savingAccount = new SavingAccount(
                "123456789",
                "Piseth Mao",
                BigDecimal.valueOf(10000),
                LocalDate.now(),
                BigDecimal.valueOf(0.01),
                card
        );
        PayrollAccount payrollAccount = new PayrollAccount(
                "123456789",
                "Piseth Mao",
                BigDecimal.valueOf(10000),
                LocalDate.now(),
                BigDecimal.valueOf(0.01),
                card
        );
        do {
            System.out.println("========================================");
            System.out.println("Welcome to the Account Management System");
            System.out.println("========================================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("Depositing...");
                    System.out.print("Enter the amount to deposit: ");
                    double amount = Double.parseDouble(input.nextLine());
//                    payrollAccount.deposit(BigDecimal.valueOf(amount));
                    savingAccount.deposit(BigDecimal.valueOf(amount));
                }
                case 2 -> {
                    System.out.println("Withdrawing...");
                    System.out.print("Enter the amount to withdraw: ");
                    double amount2 = Double.parseDouble(input.nextLine());
//                    payrollAccount.withdraw(BigDecimal.valueOf(amount2));
                    savingAccount.withdraw(BigDecimal.valueOf(amount2));
                }
                case 3 -> savingAccount.checkBalance(); // payrollAccount.checkBalance();
                case 4 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        } while (true);
    }
}
