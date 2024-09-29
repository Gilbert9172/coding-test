package algorithm.sort.validAnagram;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        // count by hashmap
        // decrease if any same char in t
        // return false if any char in t, not in s
        // finally, check if any char still have count > 0
        int[] count = new int[26];

        for (char c : s.toCharArray())
            count[c - 'a']++;

        for (char c : t.toCharArray())
            count[c - 'a']--;

        for (int num : count) {
            if (num != 0)
                return false;
        }
        return true;
    }
}