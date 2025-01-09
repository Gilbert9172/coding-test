package array.medium.quiz198;

public class SolutionV4 {

    public int rob(int[] nums) {
        // a는 두 집 전까지의 최대 금액
        // b는 직전 집까지의 최대 금액
        int prev2 = 0, prev1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // c : 현재 집(i번째 집)을 털거나 털지 않는 두 경우의 최대값
            int current = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        // int[] nums = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        SolutionV4 solution = new SolutionV4();
        int answer = solution.rob(nums);
        System.out.println(answer);
    }

}
