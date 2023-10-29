package Week4.Lecture;

import java.util.Date;

public class StartMe {
    public static void main(String[] args) {
        CreditCard becirsCard = new CreditCard(10, new Date(System.currentTimeMillis()),
                100, "123", CardType.CREDIT, CardIssuer.MASTERCARD);

        CreditCard anjasCard = new CreditCard(1000);

        CreditCard samirasCard = new CreditCard(1234567, new Date(2020, 10, 11), 75, "123", CardType.DEBIT, CardIssuer.VISA);

        becirsCard.withdrawal(40);
        becirsCard.deposit(1000);
        System.out.println(becirsCard.getBalance());
    }
}
