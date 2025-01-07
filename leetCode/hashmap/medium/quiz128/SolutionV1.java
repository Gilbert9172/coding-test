package hashmap.medium.quiz128;

import java.util.Arrays;

// O(nlogn)
public class SolutionV1 {

    public int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        int maxLength = -1;

        int cursor = 0;
        int currentLength = 1;
        while (cursor < nums.length - 1) {
            int current = nums[cursor];
            int next = nums[cursor + 1];

            if (Math.abs(next - current) == 1) {
                currentLength++;
                cursor++;
            } else if (current == next) {
                cursor++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                cursor++;
                currentLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currentLength);
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};

        SolutionV1 solution = new SolutionV1();
        int answer = solution.longestConsecutive(nums);
        System.out.println(answer);
    }
}
