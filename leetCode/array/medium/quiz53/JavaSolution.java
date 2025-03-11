package array.medium.quiz53;

// Divide and Conquer
public class JavaSolution {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int answer = maxSubArray(nums, 0, nums.length - 1);
        System.out.println(answer);
    }

    private static int maxSubArray(int[] nums, int lo, int hi) {
        if (lo == hi) { // base case: one number
            return nums[lo];
        }
        // divide
        int mid = lo + (hi - lo) / 2;
        // conquer
        int leftSum = maxSubArray(nums, lo, mid);
        int rightSum = maxSubArray(nums, mid + 1, hi);
        // combine
        int crossSum = crossSum(nums, lo, hi);
        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    // invariant: lo < hi (left part and right part both have at least 1 element
    private static int crossSum(int[] nums, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        // left
        int leftSum = 0, leftMax = Integer.MIN_VALUE; // the invariant means that leftMax and rightMax will be updated
        for (int i = mid; i >= lo; --i) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        // right
        int rightSum = 0, rightMax = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= hi; ++i) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return leftMax + rightMax;
    }

}
