package GiaiDoan1.day01;

public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;

        if (ownerName != null && !ownerName.trim().isEmpty()) {
            this.ownerName = ownerName;
        }

        if (initialBalance >= 0) {
            this.balance = initialBalance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public boolean canWithdraw(double amount) {
        return amount > 0 && this.balance >= amount;
    }

    public void withdraw(double amount) {
        if (canWithdraw(amount)) {
            this.balance -= amount;
        }
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public double getBalance() {
        return this.balance;
    }
}
