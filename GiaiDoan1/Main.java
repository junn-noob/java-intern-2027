package giaidoan1;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST TÀI KHOẢN NGÂN HÀNG ===");

        // 1. Khởi tạo tài khoản hợp lệ
        BankAccount acc = new BankAccount("ACC-001", "Nguyen Van An", 500_000);
        System.out.println("Tài khoản: " + acc.getAccountNumber());
        System.out.println("Chủ thẻ: " + acc.getOwnerName());
        System.out.println("Số dư ban đầu: " + acc.getBalance() + " VNĐ");

        // 2. Thử nạp tiền
        acc.deposit(200_000);
        System.out.println("\n-> Nạp thêm 200,000 VNĐ. Số dư hiện tại: " + acc.getBalance() + " VNĐ");

        // 3. Thử rút tiền hợp lệ
        acc.withdraw(300_000);
        System.out.println("\n-> Rút 300,000 VNĐ. Số dư hiện tại: " + acc.getBalance() + " VNĐ");

        // 4. Thử rút số tiền âm (Hacker test)
        System.out.println("\n-> Thử rút số tiền âm (-500,000 VNĐ):");
        acc.withdraw(-500_000);
        System.out.println("Số dư sau khi thử rút âm: " + acc.getBalance() + " VNĐ (Không bị hack!)");

        // 5. Thử rút vượt quá số dư
        System.out.println("\n-> Thử rút vượt quá số dư (1,000,000 VNĐ):");
        acc.withdraw(1_000_000);
        System.out.println("Số dư sau khi thử rút lố: " + acc.getBalance() + " VNĐ (Được bảo vệ an toàn!)");
    }
}
