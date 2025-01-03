package string.medium.quiz80;

public class SolutionV1 {
    public int removeDuplicates(int[] nums) {

        int idx = 0;
        for (int num : nums) {
            if (idx < 2 || nums[idx - 2] != num) {
                nums[idx++] = num;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};

        SolutionV1 solution = new SolutionV1();
        int answer = solution.removeDuplicates(nums);
        System.out.println(answer);
    }

}
