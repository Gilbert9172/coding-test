package datastructure.linear.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -5};
        int[] nums = {0, 0, 0};
        List<List<Integer>> solve = solve(nums);
        System.out.println(solve);
    }

    public static List<List<Integer>> solve(int[] nums) {
        int left, right, total;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -2; i++) {
            // 중복된 값 건너뛰기
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                total = nums[i] + nums[left] + nums[right];
                if (total > 0) {
                    right --;
                } else if (total < 0) {
                    left ++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 중복된 값 건너 뛰기, 이 처리를 하지 않으면 같은 정답이 주번 나올 수 있다.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right --;
                    }
                    left ++;
                    right --;
                }
            }
        }
        return res;
    }
}
