package GiaiDoan1.day06;

public class NoRepeatSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int l = 0;
        int[] count = new int[256];

        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r)]++;
            while (count[s.charAt(r)] > 1) {
                count[s.charAt(l)]--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
