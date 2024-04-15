package Bank;

import java.util.Scanner;

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
            chooseOption(currentAccount);
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

    }

    public static void chooseOption(Account account) {
        int choice = Integer.parseInt(scanner.nextLine());
        int cash;
        String pin;
        switch (choice) {
            case 1:
                System.out.println("Enter sum");
                cash = scanner.nextInt();
                account.setBalance(account.getBalance() - cash);
                System.out.println("Your balance is: " + account.getBalance());
                System.out.println();
                break;
            case 2:
                System.out.println("Your balance is: $" + account.getBalance());
                System.out.println();
                break;
            case 3:
                System.out.println("Enter new pin");
                pin = scanner.nextLine();
                account.setCardPin(pin);
                System.out.println("Your pin is: " + pin);
                System.out.println();
                break;
            case 4:
                System.out.println("Enter sum");
                cash = scanner.nextInt();
                account.setBalance(account.getBalance() + cash);
                System.out.println("Your balance is: " + account.getBalance());
                System.out.println();
                break;
            case 5:
                System.out.println("Account data:");
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
