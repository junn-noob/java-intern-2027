package GiaiDoan1.day05;

public class ContainerWithMostWater {
    // Time Complexity: O(N) - duyệt qua mảng đúng 1 lượt bằng 2 con trỏ hội tụ
    // Space Complexity: O(1) - In-place trên Stack, không tốn thêm Heap
    public static int maxArea(int[] height) {
        // Defensive check: mảng rỗng, null hoặc < 2 thanh chắn thì không thể tạo bể
        if (height == null || height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            // Chiều cao bị giới hạn bởi cột thấp hơn
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;

            maxWater = Math.max(maxWater, currentArea);

            // Bắt buộc vứt bỏ cột thấp hơn để đi tìm cột cao hơn
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
