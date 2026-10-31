package GiaiDoan1.day03;

public abstract class BasePayment implements PaymentMethod {
    private final String transactionId;
    private double amount;

    public BasePayment(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }
}