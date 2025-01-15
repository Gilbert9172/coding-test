package dynamic.medium.quiz300;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchSolution {

    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            if (res.isEmpty() || res.getLast() < n) {
                res.add(n);
            } else {
                int idx = binarySearch(res, n);
                res.set(idx, n);
            }
        }

        return res.size();
    }

    private int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        BinarySearchSolution bs = new BinarySearchSolution();
        int answer = bs.lengthOfLIS(nums);
        System.out.println(answer);
    }

}
