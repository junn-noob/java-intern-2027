package GiaiDoan1.challenge03;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   KIỂM THỬ HỆ THỐNG PHÂN PHỐI ĐƠN HÀNG FLASH SALE");
        System.out.println("==================================================");

        // TEST 1: TẤN CÔNG BỘ NHỚ HEAP (DEEP DEFENSIVE COPYING)
        System.out.println("\n--- [TEST 1] KIỂM TRA CHỐNG TẤN CÔNG BỘ NHỚ HEAP ---");
        OrderItem ao = new OrderItem("Áo sơ mi", 500_000, 1);
        OrderItem quan = new OrderItem("Quần âu", 300_000, 1);
        OrderItem[] rawItems = { ao, quan };

        StandardOrder order = new StandardOrder("ORD-SECURE", rawItems);

        // Kẻ gian sửa mảng ngoài đời
        rawItems[0].setUnitPrice(1.0);
        // Kẻ gian lấy mảng từ hàm getItems() ra sửa
        order.getItems()[1].setUnitPrice(2.0);

        boolean deepCopySafe = (order.getItems()[0].getUnitPrice() == 500_000) 
                            && (order.getItems()[1].getUnitPrice() == 300_000);
        System.out.println("Tấn công sửa giá từ bên ngoài: " 
            + (deepCopySafe ? "✅ AN TOÀN TUYỆT ĐỐI (Đã chặn đứng hack giá)" : "❌ THẤT BẠI (Giá đã bị sửa)"));

        // TEST 2: ĐƠN HÀNG TIÊU CHUẨN (STANDARD ORDER)
        System.out.println("\n--- [TEST 2] KIỂM TRA ĐƠN HÀNG TIÊU CHUẨN ---");
        // Tổng tiền gốc = 500k + 300k = 800k. Mã SALE10 giảm 10% (80k) -> còn 720k. Phí ship cố định 30k -> 750k
        double standardWithVoucher = order.calculateFinalPayment("SALE10", 10.0);
        System.out.println("Áp mã SALE10: Tổng thanh toán = " + (long)standardWithVoucher + " VNĐ (Kỳ vọng: 750.000) -> "
            + (standardWithVoucher == 750_000 ? "✅ PASS" : "❌ FAIL"));

        // Khách không nhập mã (truyền null) -> Không giảm giá, 800k + 30k ship = 830k. Không được crash NPE!
        double standardNullVoucher = order.calculateFinalPayment(null, 10.0);
        System.out.println("Khách truyền mã null: Tổng = " + (long)standardNullVoucher + " VNĐ (Kỳ vọng: 830.000) -> "
            + (standardNullVoucher == 830_000 ? "✅ PASS (Null-Safe)" : "❌ FAIL"));

        // TEST 3: ĐƠN HÀNG GIỜ VÀNG (FLASH SALE ORDER & INVARIANT QUANTITY <= 2)
        System.out.println("\n--- [TEST 3] KIỂM TRA ĐƠN FLASH SALE & QUY TẮC SỐ LƯỢNG ---");
        // Đơn 1: Mua hợp lệ (mỗi món <= 2 cái)
        OrderItem flashItem1 = new OrderItem("Tai nghe", 200_000, 2);
        FlashSaleOrder validFlash = new FlashSaleOrder("FLASH-OK", new OrderItem[]{ flashItem1 });
        // Tiền gốc = 400k. Tự động giảm 30% (120k) -> còn 280k. Freeship = 0đ -> Tổng = 280k
        double validFlashTotal = validFlash.calculateFinalPayment("", 5.0);
        System.out.println("Flash sale hợp lệ: Tổng = " + (long)validFlashTotal + " VNĐ (Kỳ vọng: 280.000) -> "
            + (validFlashTotal == 280_000 ? "✅ PASS" : "❌ FAIL"));

        // Đơn 2: Gian lận găm hàng (Mua 3 cái tai nghe > 2)
        OrderItem flashItemCheat = new OrderItem("Tai nghe", 200_000, 3);
        FlashSaleOrder cheatFlash = new FlashSaleOrder("FLASH-CHEAT", new OrderItem[]{ flashItemCheat });
        double cheatFlashTotal = cheatFlash.calculateFinalPayment("", 5.0);
        System.out.println("Flash sale găm hàng (SL = 3 > 2): Kết quả = " + cheatFlashTotal + " (Kỳ vọng: -1.0 Từ chối) -> "
            + (cheatFlashTotal == -1.0 ? "✅ PASS (Đã chặn đứng gian lận)" : "❌ FAIL"));

        // TEST 4: DỊCH VỤ PHÂN PHỐI ĐƠN HÀNG (ORDER DISPATCH SERVICE)
        System.out.println("\n--- [TEST 4] KIỂM TRA TÍNH TỔNG DOANH THU (ORDER DISPATCH SERVICE) ---");
        BaseOrder[] orderBatch = { order, validFlash, cheatFlash, null };
        OrderDispatchService dispatch = new OrderDispatchService(orderBatch);
        // Đơn hợp lệ: order (áp mã null = 830k) + validFlash (280k) = 1.110.000 VNĐ. Đơn cheatFlash bị bỏ qua.
        double totalRevenue = dispatch.calculateTotalRevenue(null, 10.0);
        System.out.println("Tổng doanh thu thực tế = " + (long)totalRevenue + " VNĐ (Kỳ vọng: 1.110.000 VNĐ) -> "
            + (totalRevenue == 1_110_000 ? "✅ PASS" : "❌ FAIL"));

        // Test truyền mảng null vào OrderDispatchService
        OrderDispatchService nullDispatch = new OrderDispatchService(null);
        System.out.println("Truyền mảng null vào service: Doanh thu = " + nullDispatch.calculateTotalRevenue(null, 0)
            + " -> ✅ PASS (Không bị crash)");

        // TEST 5: THUẬT TOÁN HỨNG NƯỚC MƯA (TRAPPING RAIN WATER - LEETCODE #42)
        System.out.println("\n--- [TEST 5] KIỂM TRA THUẬT TOÁN HỨNG NƯỚC MƯA (LEETCODE #42) ---");
        int[] h1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int res1 = WarehouseBufferOptimizer.calculateTrapWater(h1);
        System.out.println("Test 5.1: [0,1,0,2,1,0,1,3,2,1,2,1] -> " + res1 + " (Kỳ vọng: 6) -> " 
            + (res1 == 6 ? "✅ PASS" : "❌ FAIL"));

        int[] h2 = { 4, 2, 0, 3, 2, 5 };
        int res2 = WarehouseBufferOptimizer.calculateTrapWater(h2);
        System.out.println("Test 5.2: [4,2,0,3,2,5]             -> " + res2 + " (Kỳ vọng: 9) -> " 
            + (res2 == 9 ? "✅ PASS" : "❌ FAIL"));

        int[] h3 = { 4, 2, 3 };
        int res3 = WarehouseBufferOptimizer.calculateTrapWater(h3);
        System.out.println("Test 5.3: [4,2,3]                   -> " + res3 + " (Kỳ vọng: 1) -> " 
            + (res3 == 1 ? "✅ PASS" : "❌ FAIL"));

        int resNull = WarehouseBufferOptimizer.calculateTrapWater(null);
        int resShort = WarehouseBufferOptimizer.calculateTrapWater(new int[]{ 1, 2 });
        System.out.println("Test 5.4: null / mảng < 3 phần tử  -> " + resNull + ", " + resShort + " (Kỳ vọng: 0, 0) -> " 
            + (resNull == 0 && resShort == 0 ? "✅ PASS" : "❌ FAIL"));

        System.out.println("\n==================================================");
        System.out.println("🎉 HOÀN THÀNH TOÀN DIỆN CAPSTONE CHALLENGE 03!");
        System.out.println("==================================================");
    }
}
