package GiaiDoan1.challenge04;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   KIỂM THỬ HỆ THỐNG DIGITAL BANKING & AML ENGINE ");
        System.out.println("==================================================");

        TransferService transferService = new TransferService();

        // 1. KIỂM TRA DEEP DEFENSIVE COPYING
        System.out.println("\n--- [TEST 1] KIỂM TRA BẢO MẬT BỘ NHỚ DEEP COPY ---");
        Transaction tx1 = new Transaction("TX-001", 500_000, "NAP_TIEN");
        Transaction[] rawTxs = { tx1 };
        CheckingAccount checking = new CheckingAccount("Nguyen Van A", "CHK-01", 2_000_000, rawTxs);

        // Kẻ gian sửa transaction bên ngoài
        // Transaction không có setter (Immutable) và BaseAccount sao chép sâu
        boolean deepCopyOk = checking.getTransactions().length == 1 
                          && checking.getTransactions()[0].getAmount() == 500_000;
        System.out.println("Bảo vệ lịch sử giao dịch: " + (deepCopyOk ? "✅ PASS" : "❌ FAIL"));

        // 2. KIỂM TRA TÀI KHOẢN TIẾT KIỆM (CẤM CHUYỂN KHOẢN & GIỮ 1 TRIỆU)
        System.out.println("\n--- [TEST 2] KIỂM TRA TÀI KHOẢN TIẾT KIỆM (SAVINGS) ---");
        SavingsAccount savings = new SavingsAccount("Le Thi B", "SAV-01", 5_000_000, new Transaction[0]);
        CheckingAccount receiver = new CheckingAccount("Tran Van C", "CHK-02", 100_000, new Transaction[0]);

        // Cố tình chuyển khoản từ sổ tiết kiệm
        boolean transferFromSavings = transferService.transfer(savings, receiver, 1_000_000);
        System.out.println("Chuyển tiền từ sổ tiết kiệm: " + transferFromSavings 
            + " (Kỳ vọng: false - Bị từ chối) -> " + (!transferFromSavings ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Số dư tiết kiệm giữ nguyên (5.000.000): " + (savings.getBalance() == 5_000_000 ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Số dư người nhận giữ nguyên (100.000): " + (receiver.getBalance() == 100_000 ? "✅ PASS" : "❌ FAIL"));

        // 3. KIỂM TRA CHUYỂN TIỀN TÀI KHOẢN THƯỜNG (PHÍ 1.000 VNĐ)
        System.out.println("\n--- [TEST 3] KIỂM TRA CHUYỂN TIỀN CHECKING ACCOUNT ---");
        // Chuyển 500.000 VNĐ từ checking (2.000.000). Phí 1k -> checking còn 1.499.000, receiver nhận 500.000 -> 600.000
        boolean transferOk = transferService.transfer(checking, receiver, 500_000);
        System.out.println("Chuyển 500k từ CHK-01 sang CHK-02: " + transferOk + " (Kỳ vọng: true) -> " 
            + (transferOk ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Số dư nguồn: " + checking.getBalance() + " VNĐ (Kỳ vọng: 1.499.000) -> " 
            + (checking.getBalance() == 1_499_000 ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Số dư đích: " + receiver.getBalance() + " VNĐ (Kỳ vọng: 600.000) -> " 
            + (receiver.getBalance() == 600_000 ? "✅ PASS" : "❌ FAIL"));

        // 4. KIỂM TRA THẺ TÍN DỤNG (CREDIT ACCOUNT - HẠN MỨC & PHÍ 4%)
        System.out.println("\n--- [TEST 4] KIỂM TRA THẺ TÍN DỤNG (CREDIT CARD) ---");
        CreditAccount credit = new CreditAccount("Pham Van D", "CRE-01", 0.0, new Transaction[0], 50_000_000);
        // Rút / chuyển 1.000.000 khi số dư đang là 0. Phí 4% là 40.000. Tổng trừ = 1.040.000 VNĐ. Số dư thành -1.040.000
        boolean creditTransfer = transferService.transfer(credit, receiver, 1_000_000);
        System.out.println("Chi tiêu thẻ tín dụng khi số dư = 0: " + creditTransfer + " (Kỳ vọng: true) -> "
            + (creditTransfer ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Số dư thẻ tín dụng sau phí 4%: " + credit.getBalance() + " VNĐ (Kỳ vọng: -1.040.000) -> "
            + (credit.getBalance() == -1_040_000 ? "✅ PASS" : "❌ FAIL"));

        // 5. KIỂM TRA THUẬT TOÁN ĐIỀU TRA RỬA TIỀN (AML 3-SUM)
        System.out.println("\n--- [TEST 5] KIỂM TRA THUẬT TOÁN ĐIỀU TRA RỬA TIỀN (AML 3-SUM) ---");
        double[] txs1 = { 10_000, 20_000, 30_000, 40_000, 60_000 };
        double target1 = 90_000;
        double[] triplet1 = AmlDetector.findFraudulentTriplet(txs1, target1);
        System.out.print("Test 5.1: Target = 90k -> Bộ 3: " + Arrays.toString(triplet1) + " ");
        boolean pass1 = triplet1.length == 3 && (triplet1[0] + triplet1[1] + triplet1[2] == target1);
        System.out.println(pass1 ? "✅ PASS" : "❌ FAIL");

        double target2 = 130_000; // 30k + 40k + 60k = 130k
        double[] triplet2 = AmlDetector.findFraudulentTriplet(txs1, target2);
        System.out.print("Test 5.2 (Cần dịch chuyển con trỏ): Target = 130k -> Bộ 3: " + Arrays.toString(triplet2) + " ");
        boolean pass2 = triplet2.length == 3 && (triplet2[0] + triplet2[1] + triplet2[2] == target2);
        System.out.println(pass2 ? "✅ PASS" : "❌ FAIL");

        double targetNoMatch = 999_999;
        double[] tripletNoMatch = AmlDetector.findFraudulentTriplet(txs1, targetNoMatch);
        System.out.print("Test 5.3 (Không có nghiệm): ");
        System.out.println(tripletNoMatch.length == 0 ? "✅ PASS (Mảng rỗng)" : "❌ FAIL");

        double[] tripletNull = AmlDetector.findFraudulentTriplet(null, 100);
        System.out.print("Test 5.4 (Mảng null / thiếu phần tử): ");
        System.out.println(tripletNull.length == 0 ? "✅ PASS (Không crash)" : "❌ FAIL");

        System.out.println("\n==================================================");
        System.out.println("KẾT THÚC BỘ KIỂM THỬ THỰC CHIẾN CAPSTONE 04!");
        System.out.println("==================================================");
    }
}

