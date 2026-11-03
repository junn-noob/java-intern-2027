package GiaiDoan1.challenge04;

public class CheckingAccount extends BaseAccount implements Withdrawable, Transferable {
    private static final double TRANSFER_FEE = 1_000;

    public CheckingAccount(String ownerName, String accountId, double balance, Transaction[] transactions) {
        super(ownerName, accountId, balance, transactions);
    }

    @Override
    public boolean canTransfer(double amount) {
        if (amount <= 0) return false;

        return this.getBalance() >= (amount + TRANSFER_FEE);
    }

    @Override
    public boolean canWithdraw(double amount) {
        if (amount < 0) return false;
        return this.getBalance() >= amount;
    }

    @Override
    public boolean transfer(double amount) {
        return super.transfer(amount + TRANSFER_FEE);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount);
    }
}
