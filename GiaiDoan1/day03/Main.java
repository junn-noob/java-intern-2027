package GiaiDoan1.day03;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   TEST DAY 03: POLYMORPHISM & ABSTRACTION        ");
        System.out.println("==================================================");

        // 1. Tạo các phương thức thanh toán khác nhau (Đa hình: Kiểu khai báo là Interface PaymentMethod)
        PaymentMethod card = new CreditCardPayment("TXN-CC-001", "9876543210987654");
        PaymentMethod momo = new MoMoPayment("TXN-MM-002", "0912345678");

        System.out.println("--- CHI TIẾT GIAO DỊCH BAN ĐẦU ---");
        System.out.println(card.getDetails());
        System.out.println(momo.getDetails());

        // 2. Đưa vào một mảng duy nhất để thanh toán hàng loạt (Đỉnh cao ĐA HÌNH)
        PaymentMethod[] paymentList = { card, momo };

        System.out.println("\n--- TIẾN HÀNH THANH TOÁN 1.000.000 VNĐ QUA PAYMENT PROCESSOR ---");
        PaymentProcessor.processAll(paymentList, 1_000_000);

        System.out.println("\n==================================================");
        System.out.println("   TEST ALGORITHM: LEETCODE #125 - VALID PALINDROME");
        System.out.println("==================================================");
        String[] testCases = {
            "A man, a plan, a canal: Panama",
            "race a car",
            " ",
            ".,",
            "0P",
            "ab_a"
        };
        boolean[] expected = { true, false, true, true, false, true };

        for (int i = 0; i < testCases.length; i++) {
            boolean actual = ValidPalindrome.isPalindrome(testCases[i]);
            System.out.println("Test " + (i + 1) + ": \"" + testCases[i] + "\" -> " + actual 
                + " (Kỳ vọng: " + expected[i] + ") " + (actual == expected[i] ? "✅ PASS" : "❌ FAIL"));
        }

        System.out.println("\n==================================================");
        System.out.println("🎉 CHÚC MỪNG! BẠN ĐÃ LÀM CHỦ TRỌN VẸN TUẦN 1 (OOP & ALGO)!");
        System.out.println("==================================================");
    }
}
