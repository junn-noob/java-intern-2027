package GiaiDoan1.review01;

public abstract class BaseOrder implements Shippable {
    private final String orderId;
    private String customerName;
    private double[] itemPrices;
    private double weightKg;

    public BaseOrder(String orderId, String customerName, double[] itemPrices, double weightKg) {
        if (orderId != null && !orderId.trim().equals("")) {
            this.orderId = orderId;
        }
        else this.orderId = "UNKNOWN";

        if (customerName != null && !customerName.trim().equals("")) {
            this.customerName = customerName;
        }

        if (itemPrices != null && itemPrices.length > 0) this.itemPrices = itemPrices.clone();
        else this.itemPrices = new double[0];

        if (weightKg > 0) this.weightKg = weightKg;
    }

    public double[] getItemPrices() {
        return this.itemPrices.clone();
    }

    public double getWeightKg() {
        return this.weightKg;
    }

    public double getTotalItemPrice() {
        double sum = 0.0;
        for (double price : itemPrices) {
            sum += price;
        }

        return sum;
    }

    protected abstract boolean canProcess();

    public void processOrder() {
        if (!canProcess()) {
            System.out.println("❌ Đơn hàng " + orderId + " BỊ TỪ CHỐI xử lý!");
            return;
        }
        double total = getTotalItemPrice() + calculateShippingFee();
        System.out.println("✅ Đơn hàng " + orderId + " (" + customerName + ") XỬ LÝ THÀNH CÔNG! Tổng thanh toán: " + total + " VNĐ");
    }

}