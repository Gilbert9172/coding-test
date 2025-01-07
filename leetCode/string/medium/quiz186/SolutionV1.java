package string.medium.quiz186;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionV1 {

    public void rotate(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int num : nums) {
            deque.add(num);
        }

        while (k != 0) {
            var element = deque.pollLast();
            deque.addFirst(element);
            k--;
        }

        int size = deque.size();
        for (int i = 0; i < size; i++) {
            nums[i] = deque.pollFirst();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        SolutionV1 solution = new SolutionV1();
        solution.rotate(nums, k);
    }

}
