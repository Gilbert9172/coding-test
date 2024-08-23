package datastructure.non_linear.graph;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), n, 1, k);
        return results;
    }

    public void dfs(List<List<Integer>> results, List<Integer> elements, int n, int start, int k) {
        if (elements.size() == k) {
            results.add(new ArrayList<>(elements));
            return;
        }
        for (int i = start; i <= n; i++) {
            elements.add(i);
            dfs(results, elements, n, i + 1, k);
            elements.removeLast();
        }
    }
}
