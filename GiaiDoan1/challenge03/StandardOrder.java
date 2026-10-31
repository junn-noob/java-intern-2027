package GiaiDoan1.challenge03;

public class StandardOrder extends BaseOrder implements VoucherAppliable {
    public StandardOrder(String orderId, OrderItem[] items) {
        super(orderId, items);
    }

    @Override
    protected boolean isValidOrder() {
        return this.getItems() != null && this.getItems().length > 0;
    }

    @Override
    protected double calculateShipping(double distanceKm) {
        return 30_000;
    }


    @Override
    public double applyVoucher(double totalAmount, String voucherCode) {
        if ("SALE10".equals(voucherCode)) return totalAmount * 0.1;
        else return 0.0;
    }
}
