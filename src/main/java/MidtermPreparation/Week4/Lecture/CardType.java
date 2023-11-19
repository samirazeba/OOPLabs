package MidtermPreparation.Week4.Lecture;

import java.security.InvalidParameterException;
import java.util.Date;

enum CardType {
    CREDIT, DEBIT
}
class AccountBalance {
    private int customerId;
    private int balance;
    private Date date;
    private boolean isActive;
    private CardType cardType;

    public int getCustomerId() {
        return customerId;
    }
    public void etCustomerId(int id) {
        this.customerId = id;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        if (balance <= 0) {
            throw new InvalidParameterException("Balance has to be greater than 0!");
        }
        this.balance = balance;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date d) {
        this.date = d;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        this.isActive = active;
    }
    public CardType getCardType() {
        return cardType;
    }
    public void setCardType (CardType ct) {
        this.cardType = ct;
    }
}
class RunAccountBalance {
    public static void main(String[] args) {
        AccountBalance ab = new AccountBalance();
        ab.setBalance(-100);
        System.out.println(ab.getBalance());
        //ab.setBalance(500);
        //System.out.println(ab.getBalance());
    }
}
