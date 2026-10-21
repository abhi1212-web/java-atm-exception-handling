package atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter account holder name: ");
            String accountHolderName = scanner.nextLine().trim();

            System.out.print("Enter available account balance: ₹");
            double accountBalance = readAmount(scanner);

            Account account = new Account(accountHolderName, accountBalance);
            System.out.println("\n--- Account Details ---");
            account.displayAccountDetails();

            System.out.print("\nEnter withdrawal amount: ₹");
            double withdrawalAmount = readAmount(scanner);

            try {
                account.withdraw(withdrawalAmount);
            } catch (InsufficientBalanceException e) {
                System.out.println("Withdrawal failed: " + e.getMessage());
                System.out.printf("Current balance: ₹%.2f%n", account.getAccountBalance());
            } catch (IllegalArgumentException e) {
                System.out.println("Withdrawal failed: " + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("ATM transaction completed.");
        }
    }

    private static double readAmount(Scanner scanner) {
        if (!scanner.hasNextDouble()) {
            if (scanner.hasNext()) {
                scanner.next();
            }
            throw new IllegalArgumentException("Please enter a numeric amount.");
        }

        double amount = scanner.nextDouble();
        scanner.nextLine();
        return amount;
    }
}
