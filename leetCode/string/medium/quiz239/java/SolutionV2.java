package string.medium.quiz239.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionV2 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        new SolutionV2().maxSlidingWindow(nums, k);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // Deque 가장 앞의 인덱스가 현재 윈도우 범위를 벗어났는지
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Deque 가장 뒤에서 자기보다 작은 값 제거
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.add(i);

            if (i >= k - 1) {
                result.add(nums[deque.peek()]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
