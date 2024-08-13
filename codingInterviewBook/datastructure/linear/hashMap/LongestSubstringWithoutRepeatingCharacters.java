package datastructure.linear.hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int answer = lengthOfLongestSubstring("abcabcbb");
        System.out.println(answer);
    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> visitedChar = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        for (char c : s.toCharArray()) {
            if (visitedChar.containsKey(c) && left <= visitedChar.get(c)) {
                left = visitedChar.get(c) + 1;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            visitedChar.put(c, right);
            right++;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringV2(String s) {
        int low=0,max=0;
        int[] a = new int[128];
        for (int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            low = Math.max(low, a[ch]);
            max = Math.max(max, i - low + 1);
            a[ch] = i + 1;
        }
        return max;
    }

}
