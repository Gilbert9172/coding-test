package backTracking.medium.quiz47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 자료구조 Set을 사용
public class V1 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> elements = Arrays.stream(nums).boxed().toList();
        List<Integer> bucket = new ArrayList<>();
        Set<List<Integer>> results = new HashSet<>();
        permutationOperator(bucket, elements, results);
        return results.stream().toList();
    }

    private void permutationOperator(
            List<Integer> bucket,
            List<Integer> elements,
            Set<List<Integer>> results
    ) {
        if (elements.isEmpty()) {
            results.add(new ArrayList<>(bucket));
        }
        for (Integer e : elements) {
            List<Integer> copied = new ArrayList<>(elements);
            copied.remove(e);

            bucket.add(e);
            permutationOperator(bucket, copied, results);
            bucket.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        V1 v1 = new V1();
        List<List<Integer>> lists = v1.permuteUnique(nums);
        System.out.println(lists.size());
    }
}
