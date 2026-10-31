package GiaiDoan1.review01;

public class StandardOrder extends BaseOrder {
    public StandardOrder(String orderId, String customerName, double[] itemPrices, double weightKg) {
        super(orderId, customerName, itemPrices, weightKg);
    }

    @Override
    protected boolean canProcess() {
        return this.getTotalItemPrice() > 0 && this.getWeightKg() <= 30.0;
    }

    @Override
    public double calculateShippingFee() {
        return this.getWeightKg() * 10_000;
    }

    @Override
    public String getShippingInfo() {
        return "Giao Hàng Tiêu Chuẩn (10k/kg)";
    }
}
