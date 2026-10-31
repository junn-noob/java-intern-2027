package GiaiDoan1.challenge03;

public class FlashSaleOrder extends BaseOrder implements VoucherAppliable, FreeShippingEligible {
    public FlashSaleOrder(String orderId, OrderItem[] items) {
        super(orderId, items);
    }

    @Override
    protected boolean isValidOrder() {
        if (this.getItems() != null) {
            for (OrderItem item : this.getItems()) {
                if (item.getQuantity() > 2) return false;
            }
        }

        return true;
    }

    @Override
    protected double calculateShipping(double distanceKm) {
        return 0;
    }

    @Override
    public double calculateShippingFee(double distanceKm) {
        return 0;
    }

    @Override
    public double applyVoucher(double totalAmount, String voucherCode) {
        return totalAmount * 0.3;
    }
}
