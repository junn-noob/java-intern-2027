package GiaiDoan1.challenge01;

public class CryptoWallet extends BaseAccount {
    public CryptoWallet(String accountId, double balance, double[] transactionHistory) {
        super(accountId, balance, transactionHistory);
    }

    @Override
    protected boolean canPay(double totalRequired) {
        return this.getBalance() - (totalRequired + this.calculateFee(totalRequired)) > 100_000;
    }

    @Override
    protected double calculateFee(double amount) {
        return amount * 0.02;
    }
}
