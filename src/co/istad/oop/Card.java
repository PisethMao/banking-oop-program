package co.istad.oop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Card {
    private String cardNumber;
    private int csv;
    private String pin;
    private BigDecimal overLimit;
    private String cardType;
    private LocalDate createdAt;
    private LocalDate expiredAt;

    public Card() {
    }

    public Card(String cardNumber, int csv, String pin, BigDecimal overLimit, String cardType, LocalDate createdAt, LocalDate expiredAt) {
        this.cardNumber = cardNumber;
        this.csv = csv;
        this.pin = pin;
        this.overLimit = overLimit;
        this.cardType = cardType;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCsv() {
        return csv;
    }

    public void setCsv(int csv) {
        this.csv = csv;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BigDecimal getOverLimit() {
        return overLimit;
    }

    public void setOverLimit(BigDecimal overLimit) {
        this.overLimit = overLimit;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(LocalDate expiredAt) {
        this.expiredAt = expiredAt;
    }
}
