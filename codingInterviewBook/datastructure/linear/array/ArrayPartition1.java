package datastructure.linear.array;

import java.util.Arrays;

public class ArrayPartition1 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2};
        int answer = solve(nums);
        System.out.println(answer);
    }

    public static int solve(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            answer += nums[i];
        }
        return answer;
    }
}
