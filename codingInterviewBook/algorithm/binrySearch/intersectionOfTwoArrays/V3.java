package algorithm.binrySearch.intersectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class V3 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;

        Set<Integer> result = new HashSet<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
