package GiaiDoan1.day06;

public class Main {
    public static void main(String[] args) {
        NoRepeatSubstring solver = new NoRepeatSubstring();

        System.out.println("=== KIEM THU LEETCODE #3: LONGEST SUBSTRING WITHOUT REPEATING ===");

        // Test 1: Chuoi mau "abcabcbb" -> 3 ("abc")
        check(solver, "abcabcbb", 3, "Test 1 (abcabcbb)");

        // Test 2: Chuoi toan ky tu trung "bbbbb" -> 1 ("b")
        check(solver, "bbbbb", 1, "Test 2 (bbbbb)");

        // Test 3: Chuoi "pwwkew" -> 3 ("wke")
        check(solver, "pwwkew", 3, "Test 3 (pwwkew)");

        // Test 4: Chuoi rong "" -> 0
        check(solver, "", 0, "Test 4 (Rong \"\")");

        // Test 5: Chuoi 1 khoang trang " " -> 1
        check(solver, " ", 1, "Test 5 (Khoang trang \" \")");

        // Test 6: Chuoi khong trung "abcdef" -> 6
        check(solver, "abcdef", 6, "Test 6 (abcdef)");

        // Test 7: Ca bien "dvdf" -> 3 ("vdf")
        check(solver, "dvdf", 3, "Test 7 (dvdf)");

        // Test 8: Ca bien "abba" -> 2 ("ab" hoac "ba")
        check(solver, "abba", 2, "Test 8 (abba)");

        // Test 9: Chuoi null (Defensive Programming)
        try {
            int nullRes = solver.lengthOfLongestSubstring(null);
            System.out.println("Test 9 (null): Ket qua = " + nullRes + " -> " + (nullRes == 0 ? "PASS" : "FAIL"));
        } catch (NullPointerException e) {
            System.out.println("Test 9 (null): [FAIL] Bi văng NullPointerException!");
        }

        // Test 10: Ky tu ngoai ASCII (Unicode/tieng Viet "aáa")
        try {
            int unicodeRes = solver.lengthOfLongestSubstring("aáa");
            System.out.println("Test 10 (Unicode \"aáa\"): Ket qua = " + unicodeRes + " (Ky vong: 2)");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test 10 (Unicode \"aáa\"): [FAIL] ArrayIndexOutOfBoundsException (Mang 128 bi tran bo nho)");
        }
    }

    private static void check(NoRepeatSubstring solver, String input, int expected, String testName) {
        int actual = solver.lengthOfLongestSubstring(input);
        boolean pass = actual == expected;
        System.out.println(testName + " -> Actual: " + actual + " | Expected: " + expected + " | " + (pass ? "PASS" : "FAIL"));
    }
}

