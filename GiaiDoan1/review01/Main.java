package giaidoan1.review01;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   CAPSTONE TEST 1: POLYMORPHISM & TEMPLATE METHOD");
        System.out.println("==================================================");

        BaseOrder order1 = new StandardOrder("ORD-STD-01", "Nguyen Van A", new double[] { 100_000, 200_000 }, 15.0); // Hợp lệ (15kg <= 30kg)
        BaseOrder order2 = new StandardOrder("ORD-STD-02", "Le Thi B", new double[] { 500_000 }, 40.0);             // Từ chối (40kg > 30kg)
        BaseOrder order3 = new ExpressOrder("ORD-EXP-03", "Tran Van C", new double[] { 300_000 }, 5.0);              // Hợp lệ (5kg <= 10kg)
        BaseOrder order4 = new ExpressOrder("ORD-EXP-04", "Pham Thi D", new double[] { 200_000 }, 15.0);             // Từ chối (15kg > 10kg)
        BaseOrder order5 = new VIPOrder("ORD-VIP-05", "Vip User 1", new double[] { 600_000 }, 20.0);                 // Hợp lệ, Free Ship (tiền >= 500k)
        BaseOrder order6 = new VIPOrder("ORD-VIP-06", "Vip User 2", new double[] { 200_000 }, 20.0);                 // Hợp lệ, Tính Ship (tiền < 500k)

        BaseOrder[] orderBatch = { order1, order2, order3, order4, order5, order6 };
        OrderProcessor.processAll(orderBatch);

        System.out.println("\n==================================================");
        System.out.println("   CAPSTONE TEST 2: DEFENSIVE COPYING HACK TEST   ");
        System.out.println("==================================================");
        double[] originalPrices = { 100_000, 200_000 };
        BaseOrder safeOrder = new StandardOrder("ORD-SAFE", "Hacker Target", originalPrices, 5.0);
        System.out.println("Tổng tiền ban đầu: " + safeOrder.getTotalItemPrice() + " VNĐ");

        // 1. Hacker cố tình sửa mảng đầu vào:
        originalPrices[0] = 999_999_999;
        // 2. Hacker cố tình sửa mảng lấy từ getter:
        safeOrder.getItemPrices()[1] = 888_888_888;

        System.out.println("Tổng tiền sau 2 đòn tấn công mảng: " + safeOrder.getTotalItemPrice() 
            + " VNĐ (Kỳ vọng: 300000.0 VNĐ -> " + (safeOrder.getTotalItemPrice() == 300_000 ? "✅ AN TOÀN TUYỆT ĐỐI" : "❌ BỊ HACK"));

        System.out.println("\n==================================================");
        System.out.println("   CAPSTONE TEST 3: TWO POINTERS REMOVE CANCELLED ");
        System.out.println("==================================================");
        double[] cartPrices = { 100_000, 0, 250_000, 0, 80_000 };
        System.out.print("Giỏ hàng trước khi lọc món hủy: [ ");
        for (double p : cartPrices) System.out.print((long)p + " ");
        System.out.println("]");

        OrderUtils.removeCancelledItems(cartPrices);

        System.out.print("Giỏ hàng sau khi Move Zeroes:   [ ");
        for (double p : cartPrices) System.out.print((long)p + " ");
        System.out.println("] (Kỳ vọng: 100000 250000 80000 0 0)");

        System.out.println("\n==================================================");
        System.out.println("🎉 HOÀN THÀNH XUẤT SẮC CAPSTONE PROJECT TUẦN 1!");
        System.out.println("==================================================");
    }
}