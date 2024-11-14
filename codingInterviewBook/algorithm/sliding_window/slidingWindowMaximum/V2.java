package algorithm.sliding_window.slidingWindowMaximum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class V2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int sourceLength = nums.length;
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i < sourceLength; i++) {
            queue.offer(nums[i]);
            if (i < k - 1) {
                continue;
            }
            if (currentMax == Integer.MIN_VALUE) {
                currentMax = queue.stream().max(Integer::compareTo).get();
            } else if (currentMax < nums[i]) {
                currentMax = nums[i];
            }
            answer.add(nums[i]);
            if (currentMax == queue.poll()) {
                currentMax = Integer.MIN_VALUE;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
