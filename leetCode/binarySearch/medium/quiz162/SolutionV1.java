package binarySearch.medium.quiz162;

public class SolutionV1 {

    public int findPeakElement(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            }
            return 1;
        }

        int idx = 1;
        int answer = 0;

        while (idx < nums.length) {
            int prev = nums[idx - 1];
            int next = idx + 1 == nums.length ? 0 : nums[idx + 1];
            int target = nums[idx];

            if (target > prev && target > next) {
                answer = idx;
                break;
            }

            idx = idx + 1;
        }


        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        SolutionV1 solution = new SolutionV1();

        int peakElement = solution.findPeakElement(nums);
        System.out.println(peakElement);
    }

}
