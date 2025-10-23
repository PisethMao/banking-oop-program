package co.istad.oop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

public class SavingAccount extends Account {
    private BigDecimal interestRate;
    private Card card;

    public SavingAccount() {
    }

    public SavingAccount(String accountNumber, String accountName, BigDecimal balance, LocalDate createdAt, BigDecimal interestRate, Card card) {
        super(accountNumber, accountName, balance, createdAt);
        this.interestRate = interestRate;
        this.card = card;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BigDecimal interestRateCalculation() {
        int years = Period.between(getCreatedAt(), LocalDate.now()).getYears();
        if (years >= 1) {
            return getBalance().multiply(BigDecimal.valueOf(interestRate.doubleValue() / 100))
                    .setScale(3, RoundingMode.FLOOR);
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public void deposit(BigDecimal amount) {
        if (card != null) {
            if (LocalDate.now().isAfter(card.getCreatedAt())) {
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
            super.deposit(amount);
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

    @Override
    public void checkBalance() {
        super.checkBalance();
        System.out.println("Interest: " + interestRate);
        System.out.println("Interest Rate: " + interestRateCalculation());
        System.out.println("========================================");
    }
}
