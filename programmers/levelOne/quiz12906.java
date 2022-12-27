package levelOne;

import java.util.*;

/**
 * 스택/큐
 * 같은 숫자는 싫어
 */
public class quiz12906 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(Solution.solution(arr)));
    }

    static class Solution {

        static Stack<Integer> stack = new Stack<>();
        public static int[] solution(int []arr) {
            for (int n : arr) {
                if (stack.isEmpty()) stack.push(n);
                else if (stack.peek() != n) stack.push(n);
            }
            return stack.stream().mapToInt(i -> i).toArray();
        }
    }
}
