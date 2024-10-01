package algorithm.binrySearch.searchInRotatedSortedArray;

public class V1 {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int leftArr = binarySearch(nums, target, 0, pivot - 1);
        if (leftArr > -1) {
            return leftArr;
        }
        return binarySearch(nums, target, pivot, nums.length - 1);
    }

    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid;
            } else if (nums[0] <= nums[mid]) { // mid 이전은 정렬이 됐다는 의미
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
