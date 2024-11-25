package backTracking.medium.quiz1593;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Before Optimization
// [LeetCode#1593] Split a String Into the Max Number of Unique Substrings
public class V1 {

    private int maxLength = Integer.MIN_VALUE;

    public int maxUniqueSplit(String s) {
        backTracking(s, 0, new ArrayList<>());
        return maxLength;
    }

    private void backTracking(
            String input,
            int cursor,
            List<String> bucket
    ) {

        String joined = String.join("", bucket);
        if (joined.length() == input.length()) {
            Set<String> unique = new HashSet<>(bucket);
            if (bucket.size() == unique.size()) {
                if (bucket.size() > maxLength) {
                    maxLength = bucket.size();
                    return;
                }
            }
        }

        for (int idx = cursor; idx < input.length(); idx++) {
            String segment = input.substring(cursor, idx + 1);
            bucket.add(segment);
            backTracking(input, cursor + segment.length(), bucket);
            bucket.removeLast();
        }
    }

    public static void main(String[] args) {
        V1 v1 = new V1();
        int answer = v1.maxUniqueSplit("ababccc");
        System.out.println(answer);
    }
}
