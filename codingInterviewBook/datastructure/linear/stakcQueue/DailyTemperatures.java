package datastructure.linear.stakcQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 739. Daily Temperatures
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {9, 7 ,5, 2, 10};
        int[] answerArray = dailyTemperaturesV2(temperatures);
        for (int i : answerArray) {
            System.out.println(i);
        }

    }

    // 런타임 느림 , 메모리 낮음
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int last = stack.pop();
                result[last] = i - last;
            }
            stack.push(i);
        }
        return result;
    }

    // 런타임 빠름 , 메모리 높음
    public static int[] dailyTemperaturesV2(int[] temperatures) {
        int n = temperatures.length;
        int[] ret = new int[n];
        int hottest = 0;
        for (int i = n-1; i >= 0; i--) {
            int cur = temperatures[i];
            if (cur >= hottest) {
                hottest = cur;
                continue;
            }

            int count = 1;
            while (cur >= temperatures[i + count]) {
                count += ret[i + count];
            }
            ret[i] = count;
        }
        return ret;
    }
}
