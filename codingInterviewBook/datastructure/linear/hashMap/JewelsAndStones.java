package datastructure.linear.hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 771. Jewels And Stones
 */
public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stonesMap = new HashMap<>();
        for (char c : stones.toCharArray()) {
            if (stonesMap.containsKey(c)){
                stonesMap.put(c, stonesMap.get(c) + 1);
            } else {
                stonesMap.put(c, 1);
            }
        }

        int countJewels = 0;
        for (char c : jewels.toCharArray()) {
            if (stonesMap.containsKey(c)) {
                countJewels += stonesMap.get(c);
            }
        }
        return countJewels;
    }

    public int numJewelsInStonesV2(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            set.add(c);
        }
        int countJewels = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) {
                countJewels++;
            }
        }
        return countJewels;
    }

    public int numJewelsInStonesV3(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }
}
