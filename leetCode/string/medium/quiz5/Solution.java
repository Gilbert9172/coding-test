package string.medium.quiz5;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        if (s.length() == 2) {
            if (isPalindrome(s)) {
                return s;
            }
        }
        int maxLength = 0;
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
            char leftChar = input.charAt(left);
            char rightChar = input.charAt(right);
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.longestPalindrome("xxx");
        System.out.println(answer);
    }
}
