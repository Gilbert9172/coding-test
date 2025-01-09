package array.medium.quiz198;

public class SolutionV3 {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp[i] means until i, max possible amount
        int[] dp = new int[nums.length + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            // 2 cases: rob current house, not rob current
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        // int[] nums = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        SolutionV3 solution = new SolutionV3();
        int answer = solution.rob(nums);
        System.out.println(answer);
    }
}
