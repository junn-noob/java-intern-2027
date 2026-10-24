package giaidoan1.day02;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
