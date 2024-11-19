package backTracking.medium.quiz46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> elements = Arrays.stream(nums).boxed().toList();
        boolean[] visited = new boolean[nums.length];

        permutationOperator(visited, elements, new ArrayList<>(), results);
        return results;
    }

    private void permutationOperator(
            boolean[] visited,
            List<Integer> elements,
            List<Integer> bucket,
            List<List<Integer>> results
    ) {
        if (bucket.size() == elements.size()) {
            results.add(new ArrayList<>(bucket));
        }
        for (int i = 0; i < elements.size(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            bucket.add(elements.get(i));

            permutationOperator(visited, elements, bucket, results);

            visited[i] = false;
            bucket.removeLast();
        }
    }
}
