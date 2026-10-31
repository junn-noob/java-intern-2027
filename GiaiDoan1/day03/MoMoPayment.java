package GiaiDoan1.day03;

public class MoMoPayment extends BasePayment {
    private final String phoneNumber;

    public MoMoPayment(String transactionId, String phoneNumber) {
        super(transactionId);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán Momo [" + this.phoneNumber + "] thành công: " + amount);
    }

    @Override
    public String getDetails() {
        return "MoMo [ID=" + getTransactionId() + ", Phone=" + phoneNumber + "]";
    }
}