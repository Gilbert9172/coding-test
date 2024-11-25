package backTracking.medium.quiz1593;

import java.util.HashSet;
import java.util.function.Supplier;

// [LeetCode#1593] Split a String Into the Max Number of Unique Substrings
public class V3 {

    public int maxUniqueSplit(String s) {
        return backtrack(0, s, new HashSet<>());
    }

    private int backtrack(int start, String s, HashSet<String> seen) {
        if (start == s.length()) {
            return 0;
        }
        int maxSplits = 0;
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (!seen.contains(sub)) {
                seen.add(sub);
                maxSplits = Math.max(maxSplits, 1 + backtrack(i, s, seen));
                seen.remove(sub);
            }
        }
        return maxSplits;
    }

    public static void main(String[] args) {
        V3 v3 = new V3();
        assertThat(() -> v3.maxUniqueSplit("ababccc"), 5);
        assertThat(() -> v3.maxUniqueSplit("aba"), 2);
        assertThat(() -> v3.maxUniqueSplit("aa"), 1);
        assertThat(() -> v3.maxUniqueSplit("abaac"), 4);
    }


    private static void assertThat(Supplier<Integer> supplier, int expected) {
        int actual = supplier.get();
        if (actual == expected) {
            System.out.println("정답");
        } else {
            System.out.println("오답");
        }
    }
}
