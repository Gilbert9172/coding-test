package string.easy.quiz20.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class SolutionV1 {

    public static void main(String[] args) {
        boolean answer = new SolutionV1().isValid("({)}");
        System.out.println(answer);
    }

    private static Map<Character, Character> bracketMap = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!bracketMap.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || bracketMap.get(c) != stack.pop()) {
                return false;
            }

        }
        return stack.isEmpty();
    }
}
