package co.istad.oop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

public class SavingAccount extends Account {
    BigDecimal interestRate;
    Card card;

    public SavingAccount(String accountNumber, String accountName, BigDecimal balance, LocalDate createdAt, BigDecimal interestRate, Card card) {
        super(accountNumber, accountName, balance, createdAt);
        this.interestRate = interestRate;
        this.card = card;
    }

    public BigDecimal getInterestRate() {
        int years = Period.between(createdAt, LocalDate.now()).getYears();
        if (years >= 1) {
            return balance.multiply(BigDecimal.valueOf(interestRate.doubleValue() / 100))
                    .setScale(3, RoundingMode.FLOOR);
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public void deposit(BigDecimal amount) {
        super.deposit(amount);
    }

    public void deposit(BigDecimal amount, int enteredPin) {
        if (card == null || card.pin != enteredPin) {
            System.out.println("Invalid PIN");
            return;
        }
        if (card.isExpired()) {
            System.out.println("Card is expired");
            return;
        }
        super.deposit(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        super.withdraw(amount);
    }

    public void withdraw(BigDecimal amount, int enteredPin) {
        if (card == null || card.pin != enteredPin) {
            System.out.println("Invalid PIN");
            return;
        }
        if (card.isExpired()) {
            System.out.println("Card is expired");
            return;
        }
        if (amount.compareTo(card.overLimit) > 0) {
            System.out.println("Transaction denied. Amount exceeds your card over-limit (" + card.overLimit + ").");
            return;
        }
        super.withdraw(amount);
    }

    @Override
    public void checkBalance() {
        super.checkBalance();
        System.out.println("Interest: " + interestRate);
        System.out.println("Interest Rate: " + getInterestRate());
        if (card != null) {
            System.out.println("Card Info: ");
            card.showCardInfo();
        } else {
            System.out.println("No card associated with this account");
        }
        System.out.println("--------------------------------------------------");
    }
}
