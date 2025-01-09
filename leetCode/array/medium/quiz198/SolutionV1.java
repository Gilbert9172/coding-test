package array.medium.quiz198;

public class SolutionV1 {

    private int answer = 0;

    public int rob(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            dfs(i + 2, nums, nums[i]);
        }

        return answer;
    }

    public void dfs(int startIdx, int[] nums, int prev) {

        if (startIdx > nums.length - 1) {
            answer = Math.max(answer, prev);
            return;
        }

        if (startIdx == nums.length - 1) {
            answer = Math.max(answer, prev + nums[startIdx]);
            return;
        }

        for (int i = startIdx; i < nums.length; i++) {
            dfs(i + 2, nums, nums[i] + prev);
        }
    }

    public static void main(String[] args) {
        int[] nums = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};

        SolutionV1 solution = new SolutionV1();
        int answer = solution.rob(nums);
        System.out.println(answer);
    }
}
