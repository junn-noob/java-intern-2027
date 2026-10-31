package GiaiDoan1.day03;

public class PaymentProcessor {
    public static void processAll(PaymentMethod[] methods, double amount) {
        for (PaymentMethod pm : methods) {
            pm.pay(amount); // <--- ĐÂY LÀ ĐA HÌNH!
            // Không cần dùng if-else xem nó là Thẻ hay MoMo,
            // máy tính tự động tìm đúng hàm của từng đối tượng trên Heap để chạy!
        }
    }
}
