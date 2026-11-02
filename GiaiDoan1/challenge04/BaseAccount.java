package GiaiDoan1.challenge04;

public class BaseAccount {
    private String ownerName;
    private final String accountId;
    private double balance;
    private Transaction[] transactions;

    public BaseAccount(String ownerName, String accountId, double balance, Transaction[] transactions) {
        if (ownerName != null) this.ownerName = ownerName;

        if (accountId != null) this.accountId = accountId;
        else this.accountId = "UNKNOWN";

        if (balance >= 0) this.balance = balance;

        if (transactions != null && transactions.length > 0) {
            this.transactions = new Transaction[transactions.length];
            for (int i = 0; i < transactions.length; i++) {
                this.transactions[i] = new Transaction(transactions[i]);
            }
        }
        else this.transactions = new Transaction[0];
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public double getBalance() {
        return this.balance;
    }

    public Transaction[] getTransactions() {
        if (this.transactions == null || this.transactions.length == 0) return new Transaction[0];

        Transaction[] newTransactions = new Transaction[this.transactions.length];
        for (int i = 0; i < this.transactions.length; i++) {
            newTransactions[i] = new Transaction(this.transactions[i]);
        }

        return newTransactions;
    }

    protected boolean canWithdraw(double amount) {
        return false;
    }

    protected boolean canTransfer(double amount) {
        return false;
    }

    protected boolean withdraw(double amount) {
        if (this.canWithdraw(amount)) {
            this.balance -= amount;
            String transactionId = "TX-" + java.util.UUID.randomUUID().toString().substring(0, 8);
            Transaction transaction = new Transaction(transactionId, amount, "RUT_TIEN");
            Transaction[] tempTransactions = this.getTransactions();
            this.transactions = new Transaction[tempTransactions.length + 1];
            System.arraycopy(tempTransactions, 0, this.transactions, 0, tempTransactions.length);
            this.transactions[this.transactions.length - 1] = transaction;
            return true;
        }

        return false;
    }

    protected boolean transfer(double amount) {
        if (this.canTransfer(amount)) {
            this.balance -= amount;
            String transactionId = "TX-" + java.util.UUID.randomUUID().toString().substring(0, 8);
            Transaction transaction = new Transaction(transactionId, amount, "CHUYEN_TIEN");
            Transaction[] tempTransactions = this.getTransactions();
            this.transactions = new Transaction[tempTransactions.length + 1];
            System.arraycopy(tempTransactions, 0, this.transactions, 0, tempTransactions.length);
            this.transactions[this.transactions.length - 1] = transaction;
            return true;
        }

        return false;
    }

    protected boolean deposit(double amount) {
        if (amount < 0) return false;

        this.balance += amount;
        return true;
    }

    protected boolean withdrawCash(double amount) {
        if (canWithdraw(amount)) {
            this.balance -= amount;
            return true;
        }

        return false;
    }
}
