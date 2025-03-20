package greedy.medium.quiz45;

// TIME LIMIT EXCEED
public class SolutionV1 {

    int minCount = (int) 1e9;

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        dfs(0, nums, 0);

        return minCount;
    }

    private int dfs(int idx, int[] nums, int count) {
        if (idx == nums.length - 1) {
            return count;
        }

        for (int i = nums[idx]; i > 0; i--) {
            if (idx + i >= nums.length) continue;
            int x = dfs(idx + i, nums, count + 1);
            minCount = Math.min(minCount, x);
        }
        return minCount;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5};

        SolutionV1 solution = new SolutionV1();
        int answer = solution.jump(nums);
        System.out.println(answer);
    }
}
