# Practicum 7: ATM Exception Handling

This Java program demonstrates checked exceptions and a user-defined
`InsufficientBalanceException` in an ATM withdrawal system.

## Concepts demonstrated

- Custom checked exception using `extends Exception`
- `throw` and `throws`
- Nested `try-catch` blocks
- `finally` for cleanup
- Validation of negative, zero, and non-numeric input
- Encapsulation in the `Account` class

## Project structure

```text
src/atm/
├── Account.java
├── InsufficientBalanceException.java
└── Main.java
```

## Compile and run

```bash
mkdir -p out
javac -d out src/atm/*.java
java -cp out atm.Main
```

## Example: successful withdrawal

```text
Enter account holder name: Rahul
Enter available account balance: ₹10000
Enter withdrawal amount: ₹3000
Withdrawal successful: ₹3000.00
Remaining balance: ₹7000.00
```

## Example: insufficient balance

```text
Enter withdrawal amount: ₹7000
Withdrawal failed: Insufficient funds: requested ₹7000.00, but only ₹5000.00 is available.
```
