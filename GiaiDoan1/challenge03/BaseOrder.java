package GiaiDoan1.challenge03;

public abstract class BaseOrder {
    private String orderId;
    private OrderItem[] items;

    public BaseOrder(String orderId, OrderItem[] items) {
        this.orderId = orderId;
        if (items != null && items.length > 0) {
            this.items = new OrderItem[items.length];
            for (int i = 0; i < items.length; i++) {
                this.items[i] = new OrderItem(items[i]);
            }
        }
        else this.items = new OrderItem[0];
    }

    protected abstract boolean isValidOrder();

    protected abstract double calculateShipping(double distanceKm);

    public String getOrderId() {
        return orderId;
    }

    public OrderItem[] getItems() {
        if (this.items == null || this.items.length == 0) return new OrderItem[0];

        OrderItem[] newOrderItem = new OrderItem[this.items.length];
        for (int i = 0; i < this.items.length; i++) {
            newOrderItem[i] = new OrderItem(this.items[i]);
        }

        return newOrderItem;
    }

    public double calculateFinalPayment(String voucherCode, double distanceKm) {
        if (items == null || items.length == 0) return 0.0;

        if (!this.isValidOrder()) return -1.0;

        double totalPrices = 0.0;
        for (OrderItem item : items) {
            if (item != null) totalPrices += (item.getUnitPrice() * item.getQuantity());

        }

        if (this instanceof VoucherAppliable) {
            VoucherAppliable voucher = (VoucherAppliable) this;
            totalPrices -= voucher.applyVoucher(totalPrices, voucherCode);
        }

        return totalPrices + this.calculateShipping(distanceKm);
    }
}
