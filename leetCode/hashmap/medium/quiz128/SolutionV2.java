package hashmap.medium.quiz128;

import java.util.HashSet;
import java.util.Set;

// O(n)
public class SolutionV2 {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int maxLen = 0;
        for (int num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;

                while (numsSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }
                maxLen = Math.max(maxLen, currentLen);
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {300, 1, 200, 3, 5, 4};

        SolutionV2 solution = new SolutionV2();
        int answer = solution.longestConsecutive(nums);
        System.out.println(answer);
    }
}
