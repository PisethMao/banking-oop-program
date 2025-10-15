package co.istad.oop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Card {
    int pin;
    BigDecimal overLimit;
    LocalDate expiredAt;

    public Card(int pin, BigDecimal overLimit, LocalDate expiredAt) {
        this.pin = pin;
        this.overLimit = overLimit;
        this.expiredAt = expiredAt;
    }

    public boolean isExpired() {
        return expiredAt.isBefore(LocalDate.now());
    }

    public void showCardInfo() {
        System.out.println("Card PIN: ****");
        System.out.println("Over Limit: " + overLimit);
        System.out.println("Expired At: " + expiredAt);
    }
}
