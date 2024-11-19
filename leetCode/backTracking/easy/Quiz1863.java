package backTracking.easy;

import java.util.ArrayList;
import java.util.List;

public class Quiz1863 {

    private final List<List<Integer>> result = new ArrayList<>();

    public int subsetXORSum(int[] nums) {
        for (int maxLength = 1; maxLength <= nums.length; maxLength++) {
            buildSubsets(new ArrayList<>(), nums, 0, maxLength);
        }
        return result.stream()
                .map(this::xorOperator)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int xorOperator(List<Integer> subset) {
        Integer XOR = 0;
        for (Integer i : subset) {
            XOR ^= i;
        }
        return XOR;
    }

    private void buildSubsets(
            List<Integer> bucket,
            int[] nums,
            int startNum,
            int maxLength
    ) {
        if (bucket.size() == maxLength) {
            result.add(new ArrayList<>(bucket));
            return;
        }
        for (int i = startNum; i < nums.length; i++) {
            bucket.add(nums[i]);
            buildSubsets(bucket, nums, i + 1, maxLength);
            bucket.removeLast();
        }
    }

    public static void main(String[] args) {
        Quiz1863 quiz1863 = new Quiz1863();

        int[] nums = {1, 3};

        int subsetXORSum = quiz1863.subsetXORSum(nums);
        System.out.println(subsetXORSum);
    }
}
