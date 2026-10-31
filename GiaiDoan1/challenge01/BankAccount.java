package GiaiDoan1.challenge01;

public class BankAccount extends BaseAccount implements Refundable {
    private static final double TRANSACTION_FEE = 5_000;

    public BankAccount(String accountId, double balance, double[] transactionHistory) {
        super(accountId, balance, transactionHistory);
    }

    @Override
    protected boolean canPay(double totalRequired) {
        return this.getBalance() - (totalRequired + TRANSACTION_FEE) >= 0;
    }

    @Override
    protected double calculateFee(double amount) {
        return 5_000;
    }

    @Override
    public boolean refund(double amount) {
        if (amount <= 0) return false;
        else  {
            super.deposit(amount);
            return true;
        }
    }
}
