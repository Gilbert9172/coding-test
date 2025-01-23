package multiDemensionDP.medium.quiz5;

import java.util.ArrayList;
import java.util.List;

// Brute Force
public class MySolution {

    private int maxLength;

    public String longestPalindrome(String s) {
        if (s.length() <= 2 && isPalindrome(s)) return s;

        List<String> participants = new ArrayList<>();
        int left = 0, right = left + 1;
        while (left < s.length() - 2) {
            if (right == s.length()) {
                left++;
                right = left + 1;
            }
            if (s.charAt(left) == s.charAt(right)) {
                String substring = s.substring(left, right + 1);
                if (isPalindrome(substring)) {
                    participants.add(substring);
                    maxLength = Math.max(maxLength, substring.length());
                }
            }
            right++;
        }
        for (String participant : participants) {
            if (participant.length() == maxLength) {
                return participant;
            }
        }
        return s.substring(0, 1);
    }

    public boolean isPalindrome(String input) {
        int left = 0, right = input.length() - 1;
        while (left <= right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        MySolution solution = new MySolution();
        String answer = solution.longestPalindrome("abbazezalpha");
        System.out.println(answer);
    }
}
