package GiaiDoan1.challenge01;

public abstract class BaseAccount implements Payable {
    private String accountId;
    private double balance;
    private double[] transactionHistory;

    public BaseAccount(String accountId, double balance, double[] transactionHistory) {
        this.accountId = accountId;
        this.balance = balance;
        if (transactionHistory != null && transactionHistory.length > 0) this.transactionHistory = transactionHistory.clone();
        else this.transactionHistory = new double[0];
    }

    @Override
    public String getAccountId() {
        return this.accountId;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    public double[] getTransactionHistory() {
        return this.transactionHistory.clone();
    }

    protected abstract boolean canPay(double totalRequired);

    protected abstract double calculateFee(double amount);

    @Override
    public boolean pay(double amount) {
        if (amount <= 0) return false;

        if (this.canPay(amount)) {
            this.balance -= (amount + calculateFee(amount));
            double[] newTransactions = new double[transactionHistory.length + 1];
            System.arraycopy(this.transactionHistory, 0, newTransactions, 0, transactionHistory.length);
            newTransactions[newTransactions.length - 1] = amount;
            this.transactionHistory = newTransactions;
            return true;
        }
        else return false;
    }

    protected void deposit(double amount) {
        if (amount > 0) this.balance += amount;
    }
}
