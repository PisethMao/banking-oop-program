package co.istad.oop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class PayrollAccount extends Account {
    BigDecimal taxRate;

    public PayrollAccount(String accountNumber, String accountName, BigDecimal balance, LocalDate createdAt, BigDecimal taxRate) {
        super(accountNumber, accountName, balance, createdAt);
        this.taxRate = taxRate;
    }

    public void calculateTax(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Amount must be greater than zero");
        }
        BigDecimal taxAmount = amount.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
        BigDecimal netSalary = amount.subtract(taxAmount).setScale(2, RoundingMode.HALF_UP);
        System.out.println("💰 Amount Salary: $" + amount.setScale(2, RoundingMode.HALF_UP));
        System.out.println("💸 Tax Deducted (" + taxRate.multiply(BigDecimal.valueOf(100)) + "%): $" + taxAmount);
        System.out.println("✅ Net Salary Deposited: $" + netSalary);
        balance = balance.add(netSalary).setScale(2, RoundingMode.HALF_UP);
        System.out.println("--------------------------------------------------");
    }

    @Override
    public void checkBalance() {
        super.checkBalance();
        System.out.println("Tax Rate: " + taxRate.multiply(BigDecimal.valueOf(100)) + "%");
        System.out.println("--------------------------------------------------");
    }
}
