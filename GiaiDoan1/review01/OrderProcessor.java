package GiaiDoan1.review01;

public class OrderProcessor {
    public static void processAll(BaseOrder[] methods) {
        for (BaseOrder sp : methods) {
            sp.processOrder(); // <--- ĐÂY LÀ ĐA HÌNH!
            // Không cần dùng if-else xem nó là Thẻ hay MoMo,
            // máy tính tự động tìm đúng hàm của từng đối tượng trên Heap để chạy!
        }
    }
}
