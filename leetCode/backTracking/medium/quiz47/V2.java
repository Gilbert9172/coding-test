package backTracking.medium.quiz47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> bucket = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);

        permutationOperator(nums, visited, bucket, results);
        return results;
    }

    public void permutationOperator(
            int[] nums,
            boolean[] visited,
            List<Integer> bucket,
            List<List<Integer>> results
    ) {
        if (bucket.size() == nums.length) {
            results.add(new ArrayList<>(bucket));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            // 중복 방지
            if (hasDuplicatedElements(i, nums, visited)) {
                continue;
            }

            visited[i] = true;
            bucket.add(nums[i]);
            permutationOperator(nums, visited, bucket, results);

            visited[i] = false;
            bucket.removeLast();
        }
    }

    private boolean hasDuplicatedElements(
            int i,
            int[] nums,
            boolean[] visited
    ) {
        return i > 0
                // 현재 숫자(nums[i])와 이전 숫자(nums[i - 1])가 동일한지 확인
                && nums[i] == nums[i - 1]
                // 이전 숫자(nums[i - 1])가 방문되지 않았다면(false), 현재 숫자(nums[i])를 선택하지 않는다.
                // 이전 숫자가 먼저 방문되지 않은 상태에서 현재 숫자를 선택하면, 동일한 순열이 두 번 생성될 가능성이 있기 때문
                && !visited[i - 1];
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        V2 v2 = new V2();
        List<List<Integer>> lists = v2.permuteUnique(nums);
        System.out.println(lists.size());
    }
}
