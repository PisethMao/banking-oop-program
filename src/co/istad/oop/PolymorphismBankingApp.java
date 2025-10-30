package co.istad.oop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PolymorphismBankingApp {
    public static void main(String[] args) {
        Card card = new Card();
        card.setCardNumber("123456789");
        card.setCsv(10000);
        card.setPin("1234");
        card.setOverLimit(BigDecimal.valueOf(10000));
        card.setCardType("VISA");
        card.setCreatedAt(LocalDate.now());
        card.setExpiredAt(LocalDate.now().plusYears(1));
        Account account = new SavingAccount(
                "123456789",
                "Piseth Mao",
                BigDecimal.valueOf(10000),
                LocalDate.now(),
                BigDecimal.valueOf(0.01),
                card
        );
        account.checkBalance();
        account = new PayrollAccount(
                "123456789",
                "Piseth Mao",
                BigDecimal.valueOf(10000),
                LocalDate.now(),
                BigDecimal.valueOf(0.01),
                card
        );
        account.checkBalance();
    }
}
