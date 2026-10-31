package GiaiDoan1.review01;

public class ExpressOrder extends BaseOrder{
    public ExpressOrder(String orderId, String customerName, double[] itemPrices, double weightKg) {
        super(orderId, customerName, itemPrices, weightKg);
    }

    @Override
    protected boolean canProcess() {
        return (this.getTotalItemPrice() > 0 && this.getWeightKg() <= 10);
    }

    @Override
    public double calculateShippingFee() {
        return this.getWeightKg() * 20_000 + 30_000;
    }

    @Override
    public String getShippingInfo() {
        return "Giao Hàng Hỏa tốc";
    }
}