package algorithm.sliding_window.slidingWindowMaximum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Limit Exceed
public class V1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int sourceLength = nums.length;

        if (sourceLength <= k) {
            return maxNumIn(nums);
        }

        List<Integer> answer = new ArrayList<>();
        int left = 0;
        int right = left + (k - 1);
        List<Integer> sourceList = Arrays.stream(nums).boxed().toList();
        while (right <= sourceLength - 1) {
            List<Integer> subList = sourceList.subList(left, right + 1);
            Integer maxNumber = subList.stream().max(Comparator.naturalOrder()).orElse(0);
            answer.add(maxNumber);
            left ++;
            right ++;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] maxNumIn(int[] targets) {
        int maxNum = Arrays.stream(targets).max().orElse(0);
        return new int[]{maxNum};
    }
}
