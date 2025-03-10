package array.easy.quiz217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Constraints:
 * 1 <= nums.length <= 100000
 * -10^9 <= nums[i] <= 10^9
 */
public class JavaSolution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Long> counterMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        for (Long count : counterMap.values()) {
            if (count > 1) return true;
        }
        return false;
    }

    public boolean containsDuplicateV2(int[] nums) {
        Set<Integer> uniqueSource = new HashSet<>();
        for (int i : nums) {
            if (!uniqueSource.add(i)) {
                return true;
            }
        }
        return false;
    }
}
