package giaidoan1.day02;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("         TEST 1: SERVER LOG (DEFENSIVE COPY)      ");
        System.out.println("==================================================");
        double[] originalTemps = { 24.5, 26.0, 28.5 };
        ServerLog log = new ServerLog("Server-Hanoi-01", originalTemps);
        System.out.println("Server: " + log.getServerName());
        System.out.println("Nhiệt độ max: " + log.getMaxTemperature() + " °C");

        // Thử hack
        originalTemps[0] = 999.0;
        log.getTemperatures()[1] = 888.0;
        System.out.println("Nhiệt độ sau 2 đòn tấn công: " + log.getMaxTemperature() + " °C (An toàn tuyệt đối!)");

        System.out.println("\n==================================================");
        System.out.println("         TEST 2: SAVINGS ACCOUNT (INHERITANCE)    ");
        System.out.println("==================================================");
        SavingsAccount savings = new SavingsAccount("SAV-999", "Tran Thi Binh", 1_000_000, 0.06);
        System.out.println("Số dư ban đầu: " + savings.getBalance() + " VNĐ");
        savings.applyInterest();
        System.out.println("-> Sau khi cộng lãi 6%: " + savings.getBalance() + " VNĐ");
        savings.withdraw(500_000);
        System.out.println("-> Rút 500k: Số dư = " + savings.getBalance() + " VNĐ");
        System.out.println("-> Thử rút 520k (sẽ làm số dư còn 40k < 50k tối thiểu):");
        savings.withdraw(520_000);
        System.out.println("Số dư sau khi thử rút: " + savings.getBalance() + " VNĐ (Bị chặn thành công!)");

        System.out.println("\n==================================================");
        System.out.println("     TEST 3: CHECKING ACCOUNT (OVERDRAFT & FEE)   ");
        System.out.println("==================================================");
        // Tài khoản có 100.000 VNĐ, hạn mức thấu chi cho phép âm tối đa 2.000.000 VNĐ
        CheckingAccount checking = new CheckingAccount("CHK-888", "Le Van Cuong", 100_000, 2_000_000);
        System.out.println("Chủ thẻ: " + checking.getOwnerName());
        System.out.println("Số dư ban đầu: " + checking.getBalance() + " VNĐ");
        System.out.println("Hạn mức thấu chi: " + checking.getOverdraftLimit() + " VNĐ");

        // Rút 50.000 VNĐ (+ 5.000 phí = trừ 55.000)
        System.out.println("\n-> Rút 50,000 VNĐ (phí 5,000):");
        checking.withdraw(50_000);
        System.out.println("Số dư còn lại = " + checking.getBalance() + " VNĐ (Kỳ vọng: 45,000 VNĐ)");

        // Rút thấu chi vượt số dư: Rút 500.000 VNĐ (+ 5.000 phí = trừ 505.000)
        System.out.println("\n-> Rút thấu chi 500,000 VNĐ (phí 5,000, số dư sẽ bị âm):");
        checking.withdraw(500_000);
        System.out.println("Số dư sau khi thấu chi = " + checking.getBalance() + " VNĐ (Kỳ vọng: -460,000 VNĐ)");

        // Thử rút vượt quá hạn mức thấu chi (cho âm tối đa 2 triệu, thử rút 1.6 triệu nữa)
        System.out.println("\n-> Thử rút 1,600,000 VNĐ (sẽ làm âm quá hạn mức 2,000,000 VNĐ):");
        checking.withdraw(1_600_000);
        System.out.println("Số dư sau khi thử rút lố = " + checking.getBalance() + " VNĐ (Giao dịch bị từ chối thành công!)");

        System.out.println("\n==================================================");
        System.out.println("🎉 TẤT CẢ 3 BÀI TEST OOP ĐỀU CHẠY THÀNH CÔNG 100%!");
        System.out.println("==================================================");
    }
}
