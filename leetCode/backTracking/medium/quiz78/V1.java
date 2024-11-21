package backTracking.medium.quiz78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 78. Subsets
public class V1 {

    private final List<List<Integer>> subsets = new ArrayList<>();
    private List<Integer> source;

    public List<List<Integer>> subsets(int[] nums) {
        initiateSource(nums);
        backTracking(new ArrayList<>(), 0);
        return subsets;
    }

    private void initiateSource(int[] nums) {
        this.source = Arrays.stream(nums).boxed().toList();
    }

    private void backTracking(
            List<Integer> subset,
            int startIdx
    ) {
        subsets.add(new ArrayList<>(subset));

        for (int i = startIdx; i < source.size(); i++) {
            subset.add(source.get(i));
            backTracking(subset, i + 1);
            subset.removeLast();
        }
    }

    public static void main(String[] args) {
        V1 v1 = new V1();
        int[] nums = {1, 2, 3};
        List<List<Integer>> answers = v1.subsets(nums);
        for (List<Integer> answer : answers) {
            System.out.println(answer.toString());
        }
    }
}
