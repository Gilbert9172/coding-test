package array.medium.quiz198;

import java.util.Arrays;

// DP
public class SolutionV2 {

    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        return memo[i];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};

        SolutionV2 solution = new SolutionV2();
        int answer = solution.rob(nums);
        System.out.println(answer);
    }
}
