package atm;

public class Account {
    private final String accountHolderName;
    private double accountBalance;

    public Account(String accountHolderName, double accountBalance) {
        if (accountHolderName == null || accountHolderName.isBlank()) {
            throw new IllegalArgumentException("Account holder name cannot be empty.");
        }
        if (accountBalance < 0) {
            throw new IllegalArgumentException("Account balance cannot be negative.");
        }

        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * Withdraws money or reports the appropriate exception to the caller.
     *
     * @param withdrawalAmount amount to withdraw
     * @throws InsufficientBalanceException when the amount exceeds the balance
     */
    public void withdraw(double withdrawalAmount) throws InsufficientBalanceException {
        if (withdrawalAmount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (withdrawalAmount > accountBalance) {
            throw new InsufficientBalanceException(withdrawalAmount, accountBalance);
        }

        accountBalance -= withdrawalAmount;
        System.out.printf("Withdrawal successful: ₹%.2f%n", withdrawalAmount);
        System.out.printf("Remaining balance: ₹%.2f%n", accountBalance);
    }

    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.printf("Account Balance: ₹%.2f%n", accountBalance);
    }
}
