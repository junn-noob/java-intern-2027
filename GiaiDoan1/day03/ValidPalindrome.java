package GiaiDoan1.day03;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) l++;
            if (!Character.isLetterOrDigit(s.charAt(r))) r--;
            if (Character.isLetterOrDigit(s.charAt(l)) && Character.isLetterOrDigit(s.charAt(r))) {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
                l++; r--;
            }
        }

        return true;
    }
}
