package string.medium.quiz49.java;

import java.util.*;

public class SolutionV1 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> answer = new SolutionV1().groupAnagrams(strs);
        answer.forEach(it -> System.out.println(it.toString()));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(result.values());
    }
}
