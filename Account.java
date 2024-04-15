package Bank;

import java.util.ArrayList;

public class Account {
    String name;
    double balance;
    String cardNumber;
    String cardPin;

    public Account(String name, double balance, String cardNumber, String cardPin) {
        this.name = name;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return cardPin;
    }

    static class Database {
        public static ArrayList<Account> accounts = new ArrayList<>();

        static {
            accounts.add(new Account("Brad Pitt", 20000, "123456789", "1234"));
            accounts.add(new Account("Johny Depp", 15000, "012345678", "1111"));
        }
    }
}

