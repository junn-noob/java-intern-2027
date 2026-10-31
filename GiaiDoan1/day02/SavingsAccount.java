package GiaiDoan1.day02;
import GiaiDoan1.day01.BankAccount;

public class SavingsAccount extends BankAccount {
    private final double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        if (interestRate > 0.0) this.interestRate = interestRate;
        else this.interestRate = 0.05;
    }

    public void applyInterest() {
        double interest = this.getBalance() * interestRate;

        this.deposit(interest);
    }

    @Override
    public boolean canWithdraw(double amount) {
        return amount > 0 && this.getBalance() - amount >= 50000;
    }

    @Override
    public void withdraw(double amount) {
        if (canWithdraw(amount)) {
            super.withdraw(amount);
        }
    }
}