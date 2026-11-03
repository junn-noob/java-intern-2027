package GiaiDoan1.challenge04;

public class SavingsAccount extends BaseAccount implements Depositable {
    public SavingsAccount(String ownerName, String accountId, double balance, Transaction[] transactions) {
        super(ownerName, accountId, balance, transactions);
    }

    @Override
    public boolean canWithdraw(double amount) {
        if (amount <= 0) return false;

        return this.getBalance() - amount >= 1_000_000;
    }

    @Override
    public boolean deposit(double amount) {
        return super.deposit(amount);
    }
}
