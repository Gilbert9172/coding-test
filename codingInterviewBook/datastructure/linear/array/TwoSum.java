package datastructure.linear.array;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.com/problems/two-sum/description">리트 코드 : 두수의 합</a>
 * */
public class TwoSum {

    public static void main(String[] args) {
        int[] initArray = {2, 6, 11, 15};
        int target = 8;
        int[] resultArray = solve2(initArray, target);
        for (int i : resultArray) {
            System.out.println(i);
        }
    }

    public static int[] solve1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // No solution found
    }

    public static int[] solve2(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                return new int[]{i, numsMap.get(target-nums[i])};
            }
        }
        return new int[]{};
    }

    public int[] solve3(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
