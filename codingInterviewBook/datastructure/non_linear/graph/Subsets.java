package datastructure.non_linear.graph;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();;
        backTracking(results, new ArrayList<>(), nums, 0);
        return results;
    }

    private void backTracking(List<List<Integer>> results, List<Integer> elements, int[] nums , int idx) {
        results.add(new ArrayList<>(elements));
        for (int i = idx; i < nums.length; i++) {
            elements.add(nums[i]);
            backTracking(results, elements, nums, i + 1);
            elements.removeLast();
        }
    }
}
