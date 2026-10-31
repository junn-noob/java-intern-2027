package GiaiDoan1.challenge03;

public class OrderDispatchService {
    private BaseOrder[] orders;

    public OrderDispatchService(BaseOrder[] orders) {
        if (orders != null && orders.length > 0) this.orders = orders.clone();
        else this.orders = new BaseOrder[0];
    }

    public double calculateTotalRevenue(String voucherCode, double distanceKm) {
        if (this.orders == null || this.orders.length == 0) return 0.0;

        double totalRevenue = 0.0;
        for (BaseOrder order : orders) {
            if (order != null && order.calculateFinalPayment(voucherCode, distanceKm) != -1) {
                totalRevenue += order.calculateFinalPayment(voucherCode, distanceKm);
            }
        }

        return totalRevenue;
    }

//    public static void main(String[] args) {
//        BaseOrder standard = new StandardOrder("OD-1", new OrderItem[] {new OrderItem("Ao", 30000, 1), new OrderItem("Quan", 20000, 1)});
//        OrderDispatchService a = new OrderDispatchService(new BaseOrder[] {standard});
//        System.out.println(a.calculateTotalRevenue("SALE10", 100));
//    }
}


