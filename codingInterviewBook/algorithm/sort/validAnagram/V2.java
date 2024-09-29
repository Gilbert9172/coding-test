package algorithm.sort.validAnagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class V2 {
    public boolean isAnagram(String s, String t) {
        return sort(s).equals(sort(t));
    }

    private String sort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
