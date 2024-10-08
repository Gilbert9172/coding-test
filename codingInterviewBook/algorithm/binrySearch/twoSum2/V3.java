package algorithm.binrySearch.twoSum2;

/**
 * Two Pointer - O(NlogN)
 */
public class V3 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            int bsTarget = target - numbers[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] < bsTarget) {
                    left = mid + 1;
                } else if (numbers[mid] > bsTarget) {
                    right = mid - 1;
                } else {
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return null;
    }
}