package Week4.Lecture;

import java.util.Date;

public class CreditCard {
    private  int cardNumber;
    private Date issueDate;
    private double balance;
    private String cvc;
    private CardType cardType;
    private CardIssuer cardIssuer;

    public CreditCard(int cardNumber, Date issueDate, double balance, String cvc, CardType cardType, CardIssuer cardIssuer) {
        //System.out.println("I'm the first constructor with all params");
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
        this.balance = balance;
        this.cvc = cvc;
        this.cardType = cardType;
        this.cardIssuer = cardIssuer;
    }
    //
    public CreditCard(int balance){
        this.cardNumber = 123;
        this.issueDate = new Date();
        this.balance = balance;
        this.cvc = "123";
        this.cardType = CardType.CREDIT;
        this.cardIssuer = CardIssuer.MASTERCARD;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardIssuer getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(CardIssuer cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    public void deposit(int amount) {
        if (amount < 2) {
            System.out.println("broken");
        } else {
            this.balance += amount;
        }
    }
    public void deposit (int amount, Date createdAt){
    }
    public void withdrawal (double w) {
        if (w > this.balance) {
            System.out.println("There is no money");
        } else {
            this.balance -= w;
        }
    }
    @Override
    public String toString(){
        return "This is a credit card with unique number ".concat(String.valueOf(this.cardNumber)).concat(" and its balance is: ")
                .concat(String.valueOf(this.cardNumber))
                .concat(" and its balance is: ")
                .concat(String.valueOf(this.balance));
    }
}
