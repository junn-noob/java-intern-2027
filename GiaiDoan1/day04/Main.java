package GiaiDoan1.day04;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   TEST 1: LISKOV SUBSTITUTION PRINCIPLE (LSP)    ");
        System.out.println("==================================================");
        Shape a = new Rectangle(5, 4);
        Shape b = new Square(5);

        printArea("Rectangle(5, 4)", a, 20);
        printArea("Square(5)", b, 25);

        System.out.println("\n==================================================");
        System.out.println("   TEST 2: LEETCODE #167 - TWO SUM II (SORTED)    ");
        System.out.println("==================================================");
        int[] nums1 = { 2, 7, 11, 15 };
        int[] res1 = TwoSumSorted.twoSum(nums1, 9);
        System.out.println("Test 1: [2, 7, 11, 15], Target = 9 -> [" + res1[0] + ", " + res1[1] + "] (Kỳ vọng: [1, 2]) "
            + (res1[0] == 1 && res1[1] == 2 ? "✅ PASS" : "❌ FAIL"));

        int[] nums2 = { 2, 3, 4 };
        int[] res2 = TwoSumSorted.twoSum(nums2, 6);
        System.out.println("Test 2: [2, 3, 4], Target = 6        -> [" + res2[0] + ", " + res2[1] + "] (Kỳ vọng: [1, 3]) "
            + (res2[0] == 1 && res2[1] == 3 ? "✅ PASS" : "❌ FAIL"));

        int[] nums3 = { -1, 0 };
        int[] res3 = TwoSumSorted.twoSum(nums3, -1);
        System.out.println("Test 3: [-1, 0], Target = -1         -> [" + res3[0] + ", " + res3[1] + "] (Kỳ vọng: [1, 2]) "
            + (res3[0] == 1 && res3[1] == 2 ? "✅ PASS" : "❌ FAIL"));

        System.out.println("\n==================================================");
        System.out.println("🎉 CHÚC MỪNG! HOÀN THÀNH XUẤT SẮC TOÀN BỘ BÀI DAY 4!");
        System.out.println("==================================================");
    }

    public static void printArea(String shapeName, Shape s, int expectedArea) {
        int actual = s.getArea();
        System.out.println(shapeName + " -> Diện tích = " + actual 
            + " (Kỳ vọng: " + expectedArea + ") " + (actual == expectedArea ? "✅ PASS" : "❌ FAIL"));
    }
}
