package twoPointer.quiz15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionV1 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int left, right, total;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                total = nums[i] + nums[left] + nums[right];
                if (total < 0) {
                    left++;
                }
                if (total > 0) {
                    right--;
                }
                if (total == 0) {
                    res.add(List.of(nums[i], nums[left], nums[right]));

                    // 중복된 값을 건너뛰어야 한다.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, -1, -1, 0, 1, 2, 2};
        SolutionV1 solution = new SolutionV1();
        solution.threeSum(nums);
    }
}
