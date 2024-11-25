package backTracking.medium.quiz1593;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

// After Optimization
// [LeetCode#1593] Split a String Into the Max Number of Unique Substrings
public class V2 {

    private int maxLength = 0;

    public int maxUniqueSplit(String s) {
        this.maxLength = Integer.MIN_VALUE;
        backTracking(s, 0, new HashSet<>());
        return maxLength;
    }

    private void backTracking(
            String input,
            int cursor,
            Set<String> bucket
    ) {
        if (cursor >= input.length()) {
            maxLength = Math.max(bucket.size(), maxLength);
            return;
        }

        for (int idx = cursor; idx < input.length(); idx++) {
            String segment = input.substring(cursor, idx + 1);
            if (!bucket.contains(segment)) {
                bucket.add(segment);
                backTracking(input, idx + 1, bucket);
                bucket.remove(segment);
            }
        }
    }

    public static void main(String[] args) {
        V2 v1 = new V2();
        assertThat(() -> v1.maxUniqueSplit("ababccc"), 5);
        assertThat(() -> v1.maxUniqueSplit("aba"), 2);
        assertThat(() -> v1.maxUniqueSplit("aa"), 1);
        assertThat(() -> v1.maxUniqueSplit("abaac"), 4);
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
