package GiaiDoan1.challenge04;

public class Transaction {
    private String transactionId;
    private double amount;
    private String description;

    public Transaction(String transactionId, double amount, String description) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.description = description;
    }

    public Transaction(Transaction other) {
        if (other != null) {
            this.transactionId = other.transactionId;
            this.amount = other.amount;
            this.description = other.description;
        }
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDescription() {
        return this.description;
    }
}
