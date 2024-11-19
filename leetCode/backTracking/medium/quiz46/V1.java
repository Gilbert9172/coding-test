package backTracking.medium.quiz46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Permutation
public class V1 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> elements = Arrays.stream(nums)
                .boxed()
                .toList();
        permutationOperator(new ArrayList<>(), elements, results);
        return results;
    }

    private void permutationOperator(
            List<Integer> bucket,
            List<Integer> elements,
            List<List<Integer>> results
    ) {
        if (elements.isEmpty()) {
            results.add(new ArrayList<>(bucket));
        }
        for (Integer element : elements) {
            List<Integer> copied = new ArrayList<>(elements);
            copied.remove(element);

            bucket.add(element);
            permutationOperator(bucket, copied, results);
            bucket.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        V1 v1 = new V1();
        List<List<Integer>> permute = v1.permute(nums);
        System.out.println(permute.size());
    }
}
