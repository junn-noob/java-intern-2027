package giaidoan1.day03;

public class CreditCardPayment extends BasePayment {
    private final String cardNumber;

    public CreditCardPayment(String transactionId, String cardNumber) {
        super(transactionId);
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        amount *= 1.02;
        System.out.println("Thanh toán thẻ tín dụng [" + this.cardNumber + "] thành công: " + amount);
    }

    @Override
    public String getDetails() {
        return "CreditCard [ID=" + super.getTransactionId() + ", Card=" + this.cardNumber + "]";
    }
}