package string.medium.quiz5;

public class SolutionV3 {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            lo = left + 1;
            maxLen = right - left - 1;
        }
    }

    public static void main(String[] args) {
        SolutionV3 solutionV3 = new SolutionV3();
        String answer = solutionV3.longestPalindrome("banana");
        System.out.println(answer);
    }
}
