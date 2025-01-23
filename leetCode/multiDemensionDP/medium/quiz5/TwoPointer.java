package multiDemensionDP.medium.quiz5;

public class TwoPointer {

    private int resLen, resIdx;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(resIdx, resIdx + resLen);
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (resLen < right - left + 1) {
                resIdx = left;
                resLen = right - left + 1;
            }
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        TwoPointer solution = new TwoPointer();
        String answer = solution.longestPalindrome("abbazezalpha");
        System.out.println(answer);
    }

}
