package string.medium.quiz239.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionV1 {
    public static void main(String[] args) {
        //Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] answer = new SolutionV1().maxSlidingWindow(nums, k);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = left + k;

        List<Integer> result = new ArrayList<>();
        while (left < nums.length - k + 1) {
            int[] subArray = Arrays.copyOfRange(nums, left, right);
            int asInt = Arrays.stream(subArray).max().getAsInt();
            result.add(asInt);

            left++;
            right = Math.min(nums.length, left + k);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
