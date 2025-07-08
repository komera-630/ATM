import java.util.Scanner;

public class ATM {
    private static String userName;
    private static String userPin;
    private static double balance = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User Registration
        System.out.println("Welcome to Java ATM Setup!");
        System.out.print("Enter your name: ");
        userName = scanner.nextLine();

        System.out.print("Set your 4-digit PIN: ");
        userPin = scanner.nextLine();

        System.out.println("\nRegistration complete! Please log in.\n");

        // Login loop
        boolean authenticated = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter your PIN: ");
            String enteredPin = scanner.nextLine();
            if (enteredPin.equals(userPin)) {
                authenticated = true;
                break;
            } else {
                System.out.println("Incorrect PIN. Try again.");
            }
        }

        if (!authenticated) {
            System.out.println("Too many failed attempts. Account locked.");
            return;
        }

        // ATM Menu
        int choice;
        do {
            System.out.println("\nHello, " + userName + "!");
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you, " + userName + ". Have a great day!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Display current balance
    private static void checkBalance() {
        System.out.printf("Your balance is: $%.2f\n", balance);
    }

    // Deposit money
    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited $%.2f. New balance: $%.2f\n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew $%.2f. Remaining balance: $%.2f\n", amount, balance);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }
}
