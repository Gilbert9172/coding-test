package greedy.medium.quiz55;

public class SolutionV2 {

    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }

    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        int[] nums = new int[]{3, 2, 1, 0, 4};
        boolean answer = solution.canJump(nums);
        System.out.println(answer);
    }
}
