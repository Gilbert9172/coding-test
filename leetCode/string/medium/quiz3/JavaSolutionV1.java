package string.medium.quiz3;

import java.util.HashMap;
import java.util.Map;

public class JavaSolutionV1 {

    public static void main(String[] args) {
        int answer = new JavaSolutionV1().lengthOfLongestSubstring("pwwkew");
        System.out.println(answer);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> visited = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        for (char c : s.toCharArray()) {
            if (visited.containsKey(c) && left <= visited.get(c)) {
                left = visited.get(c) + 1;
            } else {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            visited.put(c, right);
            right++;
        }

        return maxLen;
    }
}
