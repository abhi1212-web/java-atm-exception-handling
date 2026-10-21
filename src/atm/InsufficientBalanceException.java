package atm;

/**
 * Raised when a withdrawal is greater than the account balance.
 */
public class InsufficientBalanceException extends Exception {
    private static final long serialVersionUID = 1L;

    public InsufficientBalanceException(double requestedAmount, double availableBalance) {
        super(String.format(
                "Insufficient funds: requested ₹%.2f, but only ₹%.2f is available.",
                requestedAmount, availableBalance));
    }
}
