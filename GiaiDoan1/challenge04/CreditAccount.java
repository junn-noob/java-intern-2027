package GiaiDoan1.challenge04;

public class CreditAccount extends BaseAccount implements Transferable, Withdrawable {
    private double overdraftLimit;
    private static final double PERCENT_FEE = 0.04;

    public CreditAccount(String ownerName, String accountId, double balance, Transaction[] transactions, double overdraftLimit) {
        super(ownerName, accountId, balance, transactions);
        if (overdraftLimit > 0) this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean canWithdraw(double amount) {
        if (amount < 0) return false;
        return this.getBalance() + this.overdraftLimit >= amount * (1 + PERCENT_FEE);
    }

    @Override
    public boolean canTransfer(double amount) {
        if (amount < 0) return false;
        return this.getBalance() + this.overdraftLimit >= amount * (1 + PERCENT_FEE);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount * (1 + PERCENT_FEE));
    }

    @Override
    public boolean transfer(double amount) {
        return super.transfer(amount * (1 + PERCENT_FEE));
    }
}
