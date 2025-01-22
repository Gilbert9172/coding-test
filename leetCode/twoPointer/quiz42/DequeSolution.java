package twoPointer.quiz42;

import java.util.Deque;
import java.util.LinkedList;

public class DequeSolution {

    private int trap(int[] heights) {
        Deque<Integer> dq = new LinkedList<>();
        int volume = 0;

        for (int i = 0; i < heights.length; i++) {

            while (!dq.isEmpty() && (heights[i] > heights[dq.peek()])) {
                int top = dq.pop();
                if (dq.isEmpty()) break;

                int distance = i - dq.peek() - 1;
                int water = Math.min(heights[i], heights[dq.peek()]) - heights[top];
                volume += distance * water;
            }

            dq.push(i);
        }

        return volume;
    }

    public static void main(String[] args) {
        DequeSolution solution = new DequeSolution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int answer = solution.trap(height);
        System.out.println(answer);
    }

}
