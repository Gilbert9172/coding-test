package algorithm.sort.validAnagram;

public class V3 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) count[c - 'a']--;
        for (int answer : count) {
            if (answer != 0) {
                return false;
            }
        }
        return true;
    }
}
