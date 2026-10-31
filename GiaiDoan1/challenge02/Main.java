package GiaiDoan1.challenge02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   KIỂM THỬ HỆ THỐNG THU PHÍ TỰ ĐỘNG KHÔNG DỪNG   ");
        System.out.println("==================================================");

        // 1. Xe cứu thương: Miễn phí, không thẻ RFID, không tài khoản
        Ambulance ambulance = new Ambulance("115-AMB-01", 3.0);

        // 2. Xe con bình thường: Có thẻ active, đủ tiền (100k > 35k)
        StandardCar carOk = new StandardCar("29A-111.11", 1.5, "ACC-01", 100_000, "RFID-01", true);

        // 3. Xe con thẻ bị hỏng / khóa (tagActive = false)
        StandardCar carBadTag = new StandardCar("30E-222.22", 1.5, "ACC-02", 100_000, "RFID-02", false);

        // 4. Xe con tài khoản hết tiền (10k < 35k)
        StandardCar carBroke = new StandardCar("51F-333.33", 1.5, "ACC-03", 10_000, "RFID-03", true);

        // 5. Xe tải đúng tải: Đăng kiểm 8 tấn, chở 8 tấn -> Phí = 50k + (8 - 5) * 5k = 65k
        HeavyTruck truckNormal = new HeavyTruck("89C-444.44", 8.0, "RFID-04", true, "ACC-04", 100_000, 8.0);

        // 6. Xe tải QUÁ TẢI: Đăng kiểm 8 tấn, chở 10 tấn (10 > 8)
        // Phí gốc = 50k + (10 - 5) * 5k = 75k. Phạt quá tải 100% -> Tổng phí = 150k!
        HeavyTruck truckOverload = new HeavyTruck("14C-555.55", 8.0, "RFID-05", true, "ACC-05", 200_000, 10.0);

        BaseVehicle[] queue = { ambulance, carOk, carBadTag, carBroke, truckNormal, truckOverload, null };
        TollBoothController booth = new TollBoothController(queue);

        System.out.println("\n--- [TEST 1] KIỂM TRA ĐIỀU KHIỂN BARIE TRẠM ETC ---");
        int passedCount = booth.openBarrierForQueue();
        System.out.println("Số xe được mở Barie qua trạm: " + passedCount + " (Kỳ vọng: 4 xe -> Cứu thương, Xe con OK, Xe tải thường, Xe tải quá tải)");
        
        System.out.println("\n--- [TEST 2] KIỂM TRA TRỪ TIỀN VÀ TRẠNG THÁI TỪNG XE ---");
        System.out.println("Xe cứu thương phí = " + ambulance.calculateBaseToll() + " VNĐ: " 
            + (ambulance.calculateBaseToll() == 0 ? "✅ PASS" : "❌ FAIL"));
        
        System.out.println("Xe con OK: Số dư còn lại = " + carOk.getBalance() + " VNĐ (Kỳ vọng: 65.000 VNĐ) -> "
            + (carOk.getBalance() == 65_000 ? "✅ PASS" : "❌ FAIL"));

        System.out.println("Xe con thẻ hỏng: Số dư giữ nguyên = " + carBadTag.getBalance() + " VNĐ -> "
            + (carBadTag.getBalance() == 100_000 ? "✅ PASS" : "❌ FAIL"));

        System.out.println("Xe con hết tiền: Số dư giữ nguyên = " + carBroke.getBalance() + " VNĐ -> "
            + (carBroke.getBalance() == 10_000 ? "✅ PASS" : "❌ FAIL"));

        System.out.println("Xe tải đúng tải: Phí 65k, số dư còn = " + truckNormal.getBalance() + " VNĐ (Kỳ vọng: 35.000 VNĐ) -> "
            + (truckNormal.getBalance() == 35_000 ? "✅ PASS" : "❌ FAIL"));

        System.out.println("Xe tải QUÁ TẢI (chở 10t / 8t): Phạt 100%, Phí 150k, số dư còn = " + truckOverload.getBalance() + " VNĐ (Kỳ vọng: 50.000 VNĐ) -> "
            + (truckOverload.getBalance() == 50_000 ? "✅ PASS" : "❌ FAIL (Chưa tính phạt quá tải!)"));

        System.out.println("\n--- [TEST 3] KIỂM TRA THUẬT TOÁN DUTCH NATIONAL FLAG (TRAFFIC CONTROLLER) ---");
        int[] lane1 = { 2, 0, 2, 1, 1, 0 };
        TrafficController.sortLaneByPriority(lane1);
        System.out.println("Test 3.1: [2, 0, 2, 1, 1, 0] -> " + Arrays.toString(lane1) + " (Kỳ vọng: [0, 0, 1, 1, 2, 2]) -> "
            + (Arrays.equals(lane1, new int[]{0, 0, 1, 1, 2, 2}) ? "✅ PASS" : "❌ FAIL"));

        int[] lane2 = { 2, 1, 0 };
        TrafficController.sortLaneByPriority(lane2);
        System.out.println("Test 3.2: [2, 1, 0]          -> " + Arrays.toString(lane2) + " (Kỳ vọng: [0, 1, 2]) -> "
            + (Arrays.equals(lane2, new int[]{0, 1, 2}) ? "✅ PASS" : "❌ FAIL"));

        int[] lane3 = { 1, 1, 1 };
        TrafficController.sortLaneByPriority(lane3);
        System.out.println("Test 3.3: [1, 1, 1]          -> " + Arrays.toString(lane3) + " (Kỳ vọng: [1, 1, 1]) -> "
            + (Arrays.equals(lane3, new int[]{1, 1, 1}) ? "✅ PASS" : "❌ FAIL"));

        System.out.println("\n==================================================");
        System.out.println("KẾT THÚC BỘ KIỂM THỬ CHALLENGE 02!");
        System.out.println("==================================================");
    }
}
