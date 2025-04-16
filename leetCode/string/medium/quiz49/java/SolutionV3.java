package string.medium.quiz49.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionV3 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> idxMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        int size = 0;
        for (String str : strs) {
            String hash = freqHashCode(str);
            Integer idx = idxMap.getOrDefault(hash, null);

            List<String> bucket;
            if (idx == null) {
                idx = size++;
                idxMap.put(hash, idx);
                bucket = new ArrayList<>();
                result.add(bucket);
            } else {
                bucket = result.get(idx);
            }
            bucket.add(str);
        }
        return result;
    }

    private String freqHashCode(String str) {
        char[] freq = new char[26];
        for (char c : str.toCharArray()) freq[c - 'a']++;
        return new String(freq);
    }
}
