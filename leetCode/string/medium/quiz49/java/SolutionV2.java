package string.medium.quiz49.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionV2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();


        for (String str : strs) {
            String hashCode = freqHashCode(str);
            map.computeIfAbsent(hashCode, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String freqHashCode(String str) {
        char[] freq = new char[26];
        for (char c : str.toCharArray()) freq[c - 'a']++;

        StringBuilder sb = new StringBuilder();
        for (int count : freq) {
            sb.append(count).append("#");
        }

        return sb.toString();
    }
}
