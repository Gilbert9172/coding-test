package dynamic.medium.quiz300;

import java.util.Arrays;

public class DpSolution {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] memo = new int[len];
        Arrays.fill(memo, 1);

        int longestSeq = 1;
        for (int i = len - 2; i >= 0; i--) {
            int cIdx = i + 1;
            while (cIdx < len) {
                if (nums[cIdx] > nums[i]) {
                    memo[i] = Math.max(memo[cIdx] + 1, memo[i]);
                    longestSeq = Math.max(longestSeq, memo[i]);
                }
                cIdx++;
            }
        }
        return longestSeq;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = {7, 7, 7, 7, 7, 7, 7};
//        int[] nums = {3, 2, 3};

        DpSolution solution = new DpSolution();
        int answer = solution.lengthOfLIS(nums);
        System.out.println(answer);
    }
}
