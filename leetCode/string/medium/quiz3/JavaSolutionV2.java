package string.medium.quiz3;

import java.util.HashSet;
import java.util.Set;

public class JavaSolutionV2 {
    public static void main(String[] args) {
        int answer = new JavaSolutionV2().lengthOfLongestSubstring("pwwkew");
        System.out.println(answer);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
