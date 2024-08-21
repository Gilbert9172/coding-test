package datastructure.non_linear.graph.permutations;

import java.util.ArrayList;
import java.util.List;

public class V2 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            path.add(nums[i]);
            visited[i] = true;
            backtrack(nums);
            visited[i] = false;
            path.removeLast();
        }
    }
}
