package string.medium.quiz80;

public class SolutionV2 {

    public int removeDuplicates(int[] nums) {

        int len = nums.length;

        if (len <= 2) {
            return len;
        }

        int k = 2;
        for (int i = 0; i < len; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
