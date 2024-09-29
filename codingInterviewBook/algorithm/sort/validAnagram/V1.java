package algorithm.sort.validAnagram;

import java.util.HashMap;
import java.util.Map;

public class V1 {
    public boolean isAnagram(String s, String t) {
        // 예외
        if (s.length() == 1) {
            return s.equals(t);
        }

        // create counter map
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            counter.put(letter, counter.getOrDefault(letter, 0) + 1);
        }

        // t 순회하면서 counter 갱신
        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            if (counter.containsKey(letter)) {
                counter.put(letter, counter.get(letter) - 1);
            } else {
                counter.put(letter, counter.getOrDefault(letter, 0) + 1);
            }
        }

        // value != 0 ? false
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
