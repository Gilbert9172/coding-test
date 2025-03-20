package greedy.medium.quiz122;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class V1 {
    public int maxProfit(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] > prices[stack.peek()]) {
                int index = stack.pop();
                result[index] = prices[i] - prices[index];
                stack.clear();
            }
            stack.push(i);
        }
        return Arrays.stream(result).sum();
    }
}
