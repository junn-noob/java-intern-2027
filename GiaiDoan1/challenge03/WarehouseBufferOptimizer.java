package GiaiDoan1.challenge03;

public class WarehouseBufferOptimizer {
    // Time Complexity: O(N) - duyệt 2 con trỏ đối xứng đúng 1 lượt
    // Space Complexity: O(1) - không tốn mảng phụ trên Heap
    public static int calculateTrapWater(int[] height) {
        if (height == null || height.length < 3) return 0;

        int l = 0, r = height.length - 1;
        int lMax = 0, rMax = 0, totalWater = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > lMax) lMax = height[l];
                else totalWater += (lMax - height[l]);
                l++;
            }
            else {
                if (height[r] > rMax) rMax = height[r];
                else totalWater += (rMax - height[r]);
                r--;
            }
        }

        return totalWater;
    }

    // Alias cho method trap LeetCode #42
    public int trap(int[] height) {
        return calculateTrapWater(height);
    }
}
