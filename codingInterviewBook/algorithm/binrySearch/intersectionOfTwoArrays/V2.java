package algorithm.binrySearch.intersectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class V2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Arrays.sort(nums1);
        for (int target : nums1) {
            int searchResult = Arrays.binarySearch(nums2, target);
            if (searchResult >= 0) {
                result.add(searchResult);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
