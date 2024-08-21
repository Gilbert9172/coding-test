package datastructure.non_linear.graph.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> elements = Arrays.stream(nums).boxed().toList();
        dfs(results, new ArrayList<>(), elements);
        return results;
    }

    private void dfs(List<List<Integer>> results, List<Integer> prevElement, List<Integer> elements) {
        if (elements.isEmpty()) {
            results.add(prevElement.stream().toList());
        }

        for (Integer e : elements) {
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            prevElement.add(e);
            dfs(results, prevElement, nextElements);
            prevElement.remove(e);
        }
    }

}
