package giaidoan1.review01;

public class VIPOrder extends BaseOrder{
    public VIPOrder(String orderId, String customerName, double[] itemPrices, double weightKg) {
        super(orderId, customerName, itemPrices, weightKg);
    }

    @Override
    protected boolean canProcess() {
        return true;
    }

    @Override
    public double calculateShippingFee() {
        return (this.getTotalItemPrice() >= 500_000 ? 0 : this.getWeightKg() * 10_000);
    }

    @Override
    public String getShippingInfo() {
        return "Giao Hàng VIP";
    }
}