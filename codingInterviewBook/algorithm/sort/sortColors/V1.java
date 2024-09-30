package algorithm.sort.sortColors;

public class V1 {
    public void sortColors(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int bIdx = i - 1;
            while (bIdx >= 0 && target < nums[bIdx]) {
                nums[bIdx + 1] =  nums[bIdx];
                nums[bIdx] = target;
                bIdx--;
            }
        }
    }
}
