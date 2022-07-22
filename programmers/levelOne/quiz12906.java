package levelOne;

import java.util.Stack;

/**
 * 스택/큐
 * 같은 숫자는 싫어
 */
public class quiz12906 {

    static Stack<Integer> stack = new Stack<>();

        public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,0,0,10};

        for (int n : arr) {
            if (stack.isEmpty()) {
                stack.push(n);
            } else if (stack.get(stack.size()-1) != n) {
                stack.push(n);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
