package co.istad.oop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class PayrollAccount extends Account {
    private BigDecimal taxRate;
    private Card card;

    public PayrollAccount(String accountNumber, String accountName, BigDecimal balance, LocalDate createdAt, BigDecimal taxRate, Card card) {
        super(accountNumber, accountName, balance, createdAt);
        this.taxRate = taxRate;
        this.card = card;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public void deposit(BigDecimal amount) {
        if (card != null) {
            if (LocalDate.now().isAfter(card.getExpiredAt())) {
                System.out.println("Card has expired!");
                return;
            }
            if (!card.getCardNumber().equals("123456789")) {
                System.out.println("Invalid card number!");
                return;
            }
            if (card.getCsv() != 10000) {
                System.out.println("Invalid card CSV!");
                return;
            }
            if (!card.getPin().equals("1234")) {
                System.out.println("Invalid card PIN!");
                return;
            }
            BigDecimal taxAmount = amount.multiply(taxRate.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP));
            BigDecimal netSalary = amount.subtract(taxAmount);
            super.deposit(netSalary);
            System.out.println("Deposit successful!");
        }
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (card != null) {
            if (LocalDate.now().isAfter(card.getExpiredAt())) {
                System.out.println("Card has expired!");
                return;
            }
            if (!card.getCardNumber().equals("123456789")) {
                System.out.println("Invalid card number!");
                return;
            }
            if (card.getCsv() != 10000) {
                System.out.println("Invalid card CSV!");
                return;
            }
            if (!card.getPin().equals("1234")) {
                System.out.println("Invalid card PIN!");
                return;
            }
            if (amount.compareTo(card.getOverLimit()) > 0) {
                System.out.println("Amount exceeds the over limit " + card.getOverLimit() + " of the card!");
            }
            super.withdraw(amount);
        }
    }
}
