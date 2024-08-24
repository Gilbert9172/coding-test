package datastructure.non_linear.graph;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backTracking(results, candidates, target, new ArrayList<>(), 0, 0);
        return results;
    }

    private void backTracking(List<List<Integer>> results, int[] candidates, int target, List<Integer> basket, int sum, int idx) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            results.add(new ArrayList<>(basket));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            int candidate = candidates[i];
            sum += candidate;
            basket.add(candidate);
            backTracking(results, candidates, target, basket, sum, i);
            Integer lastElement = basket.removeLast();
            sum -= lastElement;
        }
    }
}
