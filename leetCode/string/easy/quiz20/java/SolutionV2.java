package string.easy.quiz20.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class SolutionV2 {
    public static void main(String[] args) {
        boolean answer = new SolutionV2().isValid("(){}");
        System.out.println(answer);
    }

    private static Map<Character, Character> bracketMap = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                deque.addLast(c);
            } else if (c == '}') {
                if (deque.isEmpty() || deque.removeLast() != '{') return false;
            } else if (c == ')') {
                if (deque.isEmpty() || deque.removeLast() != '(') return false;
            } else if (c == ']') {
                if (deque.isEmpty() || deque.removeLast() != '[') return false;
            }
        }

        return deque.isEmpty();
    }
}
