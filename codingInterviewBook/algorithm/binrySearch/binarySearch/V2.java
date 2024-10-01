package algorithm.binrySearch.binarySearch;

public class V2 {

    private int recursive(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                return recursive(nums, mid + 1, end, target);
            } else if (nums[mid] > target) {
                return recursive(nums, start, mid - 1, target);
            }
            return mid;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return recursive(nums, start, end, target);
    }
}
