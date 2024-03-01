package Bank;

import java.util.ArrayList;
import java.util.Scanner;

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

class ATM {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.println("Welcome to the ATM");
        System.out.print("Enter your card number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String cardPin = scanner.nextLine();

        Account currentAccount = trueUser(cardNumber, cardPin);

        if (currentAccount != null) {
            System.out.println("Authentication successful!");
            menu();
        } else {
            System.out.println("Authentication failed. Please try again.");
            start();
        }
    }

    public static void menu() {
        System.out.println("Choose an option:");
        System.out.println("1. Cash Withdraw");
        System.out.println("2. Check Balance");
        System.out.println("3. Change PIN");
        System.out.println("4. Deposit");
        System.out.println("5. View Account Data");
        System.out.println("6. Exit");
        System.out.println();

        int choice = Integer.parseInt(scanner.nextLine());
        chooseOption(choice);
    }

    public static void chooseOption(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Withdraw cash option selected.");
                System.out.println();
                break;
            case 2:
                System.out.println("Your balance is: $" + Account.Database.accounts.get(0).getBalance());
                System.out.println();
                break;
            case 3:
                System.out.println("Change PIN option selected.");
                System.out.println();
                break;
            case 4:
                System.out.println("Deposit option selected.");
                System.out.println();
                break;
            case 5:
                System.out.println("Account data:");
                Account account = Account.Database.accounts.get(0);
                System.out.println("Name: " + account.getName());
                System.out.println("Card Number: " + account.getCardNumber());
                System.out.println("Balance: $" + account.getBalance());
                System.out.println();
                break;
            case 6:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                menu();
        }
        menu();
    }

    public static Account trueUser(String cardNumber, String pin) {
        for (Account account : Account.Database.accounts) {
            if (account.getCardNumber().equals(cardNumber) && account.getPin().equals(pin)) {
                return account;
            }
        }
        return null;
    }
}

