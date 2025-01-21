package array.medium.quiz274;

import java.util.Arrays;

public class CountingArray {

    public static void main(String[] args) {

        int[] nums = {2, 5, 3, 0, 2, 3, 0, 3};

        // Step 1
        int maxElement = Arrays.stream(nums).max().getAsInt();

        // Step 2
        int[] countArray = new int[maxElement + 1];

        // Step 3
        for (int num : nums) {
            countArray[num]++;
        }

        // Step 4
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i - 1] + countArray[i];
        }

        // Step 5
        int[] outputArray = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int inputNum = nums[i];

            int count = countArray[inputNum];
            countArray[inputNum]--;

            outputArray[count - 1] = inputNum;
        }

        // Step 6
        String result = Arrays.stream(outputArray).boxed().toList().toString();
        System.out.println(result);
    }

}
