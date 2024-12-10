package greedy.medium.quiz55;

public class Solution {

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 1, 0, 4};
        boolean answer = solution.canJump(nums);
        System.out.println(answer);
    }
}
