package algorithm.sort.sortColors;

public class V2 {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid < high) {
            if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
        }
    }

    private void swap(int[] nums, int v1, int v2) {
        int temp = nums[v2];
        nums[v2] = nums[v1];
        nums[v1] = temp;
    }
}
