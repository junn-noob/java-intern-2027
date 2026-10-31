package GiaiDoan1.challenge01;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   KHOA TEST GIAO DICH & FINTECH SETTLEMENT ENGINE");
        System.out.println("==================================================");

        // TEST 1: REFUND TEST
        System.out.println("\n--- [TEST 1] KIỂM TRA TÍNH NĂNG HOÀN TIỀN (REFUND) ---");
        BankAccount bank = new BankAccount("VIB-01", 100_000, new double[]{10_000});
        boolean refundResult = bank.refund(50_000);
        System.out.println("Hoàn 50.000 VNĐ vào VIB-01 (Số dư gốc: 100.000 VNĐ)...");
        System.out.println("Kết quả refund(): " + refundResult + " | Số dư hiện tại: " + bank.getBalance() 
            + " (Kỳ vọng: true, Số dư: 150.000) -> " + (refundResult && bank.getBalance() == 150_000 ? "✅ PASS" : "❌ FAIL"));

        // TEST 2: TRỪ PHÍ GIAO DỊCH & CẬP NHẬT LỊCH SỬ GIAO DỊCH
        System.out.println("\n--- [TEST 2] KIỂM TRA TRỪ PHÍ & CẬP NHẬT LỊCH SỬ ---");
        BankAccount bank2 = new BankAccount("VCB-02", 100_000, new double[0]);
        boolean payResult = bank2.pay(20_000);
        double[] historyAfterPay = bank2.getTransactionHistory();
        boolean historyUpdated = historyAfterPay.length == 1 && historyAfterPay[0] == 20_000;
        System.out.println("Thanh toán 20.000 VNĐ từ VCB-02 (Phí cố định: 5.000 VNĐ)...");
        System.out.println("Kết quả pay(): " + payResult + " | Số dư còn lại: " + bank2.getBalance() 
            + " (Kỳ vọng: 75.000 VNĐ) -> " + (bank2.getBalance() == 75_000 ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Lịch sử giao dịch được cập nhật: " + (historyUpdated ? "✅ PASS" : "❌ FAIL"));

        // TEST 3: CRYPTO WALLET CANPAY & PHÍ 2%
        System.out.println("\n--- [TEST 3] KIỂM TRA CRYPTO WALLET PHÍ 2% & HẠN MỨC 100K ---");
        CryptoWallet btc = new CryptoWallet("BTC-01", 200_000, new double[0]);
        // Rút 90.000 -> Phí 2% là 1.800 -> Tổng trừ: 91.800 -> Số dư còn lại: 108.200 (> 100.000) -> HỢP LỆ
        boolean cryptoPay1 = btc.pay(90_000);
        System.out.println("Rút 90.000 VNĐ từ ví BTC (200.000 VNĐ): " + cryptoPay1 + " | Số dư: " + btc.getBalance()
            + " (Kỳ vọng: true, Số dư: 108.200) -> " + (cryptoPay1 && btc.getBalance() == 108_200 ? "✅ PASS" : "❌ FAIL"));

        // TEST 4: SETTLEMENT ENGINE BATCH PAYMENT COUNT
        System.out.println("\n--- [TEST 4] KIỂM TRA ĐỐI SOÁT HÀNG LOẠT (SETTLEMENT ENGINE) ---");
        BankAccount brokeAccount = new BankAccount("BROKE-01", 1_000, new double[0]); // Không đủ tiền thanh toán 50k
        Payable[] batch = { bank, brokeAccount, null };
        SettlementEngine engine = new SettlementEngine(batch);
        int successCount = engine.processBatchPayment(50_000);
        System.out.println("Tổng số giao dịch thành công: " + successCount + " (Kỳ vọng: 1 tài khoản thành công) -> " 
            + (successCount == 1 ? "✅ PASS" : "❌ FAIL"));

        // TEST 5: THUẬT TOÁN TRANSACTION AUDITOR (FIND SUSPICIOUS PAIR)
        System.out.println("\n--- [TEST 5] KIỂM TRA THUẬT TOÁN TWO POINTERS AUDITOR ---");
        double[] trans1 = { 10_000, 25_000, 40_000, 60_000, 90_000 };
        double target1 = 65_000; // Cặp chính xác: 25.000 + 40.000 = 65.000
        double[] pair1 = TransactionAuditor.findSuspiciousPair(trans1, target1);
        System.out.print("Test 5.1: Target = 65k -> Cặp: [" + (long)pair1[0] + ", " + (long)pair1[1] + "] ");
        System.out.println(pair1[0] == 25_000 && pair1[1] == 40_000 ? "✅ PASS" : "❌ FAIL");

        double[] transHard = { 10.0, 50.0, 100.0, 200.0 };
        double targetHard = 210.0; // Cặp chính xác ở 2 đầu: 10 + 200 = 210
        double[] pairHard = TransactionAuditor.findSuspiciousPair(transHard, targetHard);
        System.out.print("Test 5.2 (Bẫy 2 đầu): Target = 210 -> Cặp: [" + (long)pairHard[0] + ", " + (long)pairHard[1] + "] ");
        System.out.println(pairHard[0] == 10.0 && pairHard[1] == 200.0 ? "✅ PASS" : "❌ FAIL");

        double[] trans2 = { 10_000, 20_000, 35_000, 70_000 };
        double target2 = 50_000; // Gần nhất: chênh lệch 5k
        double[] pair2 = TransactionAuditor.findSuspiciousPair(trans2, target2);
        System.out.print("Test 5.3 (Gần nhất không trùng): Target = 50k -> Cặp: [" + (long)pair2[0] + ", " + (long)pair2[1] + "] ");
        System.out.println(Math.abs(pair2[0] + pair2[1] - target2) == 5_000 ? "✅ PASS" : "❌ FAIL");

        // TEST 6: DEFENSIVE COPYING HACK TEST
        System.out.println("\n--- [TEST 6] KIỂM TRA DEFENSIVE COPYING MẢNG LỊCH SỬ ---");
        double[] originalHistory = { 1000, 2000 };
        BankAccount hackBank = new BankAccount("HACK-01", 50_000, originalHistory);
        originalHistory[0] = 999_999_999;
        hackBank.getTransactionHistory()[1] = 888_888_888;
        boolean safe = hackBank.getTransactionHistory()[0] == 1000 && hackBank.getTransactionHistory()[1] == 2000;
        System.out.println("Tấn công sửa mảng từ bên ngoài: " + (safe ? "✅ AN TOÀN TUYỆT ĐỐI" : "❌ BỊ HACK"));

        System.out.println("\n==================================================");
        System.out.println("🎉 CHÚC MỪNG: HOÀN THÀNH XUẤT SẮC TOÀN BỘ BÀI TEST!");
        System.out.println("==================================================");
    }
}
