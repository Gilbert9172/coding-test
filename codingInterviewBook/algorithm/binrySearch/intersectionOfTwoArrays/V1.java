package algorithm.binrySearch.intersectionOfTwoArrays;

import java.util.*;

// O(n+m)
public class V1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : nums1) {
            if (!counter.containsKey(i)) {
                counter.put(i, 1);
            }
        }

        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            if (counter.containsKey(i)) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
