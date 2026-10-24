package giaidoan1.day01;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("            TEST DAY 01: BANK ACCOUNT             ");
        System.out.println("==================================================");

        BankAccount acc = new BankAccount("ACC-001", "Nguyen Van An", 500_000);
        System.out.println("Tài khoản: " + acc.getAccountNumber());
        System.out.println("Chủ thẻ: " + acc.getOwnerName());
        System.out.println("Số dư ban đầu: " + acc.getBalance() + " VNĐ");

        acc.deposit(200_000);
        System.out.println("-> Nạp 200,000 VNĐ. Số dư hiện tại: " + acc.getBalance() + " VNĐ");

        acc.withdraw(300_000);
        System.out.println("-> Rút 300,000 VNĐ. Số dư hiện tại: " + acc.getBalance() + " VNĐ");

        System.out.println("\n[ATTACK] Thử rút số tiền âm (-500,000 VNĐ):");
        acc.withdraw(-500_000);
        System.out.println("Số dư sau khi thử rút âm: " + acc.getBalance() + " VNĐ (Không bị hack!)");

        System.out.println("\n==================================================");
        System.out.println("          TEST DAY 01: STOCK PROFIT               ");
        System.out.println("==================================================");
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int profit = StockProfit.maxProfit(prices);
        System.out.println("Giá cổ phiếu: [7, 1, 5, 3, 6, 4]");
        System.out.println("Lợi nhuận tối đa tính được: " + profit + " (Kỳ vọng: 5)");
    }
}
