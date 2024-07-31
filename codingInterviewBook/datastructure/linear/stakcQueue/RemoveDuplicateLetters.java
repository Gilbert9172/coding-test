package datastructure.linear.stakcQueue;

import java.util.*;

/**
 * 316. Remove Duplicate Letters
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        String input = "dbacdcbc";
        String answer = removeDuplicateLetters(input);
        System.out.println(answer);
    }
    public static String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();

        // 1. counter 채워주기
        for (char c : s.toCharArray()) {
            upsertHashValue(c, counter);
        }

        for (char c : s.toCharArray()) {
            counter.put(c, counter.get(c) - 1);
            if (seen.get(c) != null && seen.get(c)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                seen.put(stack.pop(), false);
            }
            stack.push(c);
            seen.put(c, true);
        }
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pollLast());
        }
        return answer.toString();
    }

    private static void upsertHashValue(Character c, Map<Character, Integer> counter) {
        if (counter.containsKey(c)) {
            counter.put(c, counter.get(c) + 1);
        } else {
            counter.put(c, 1);
        }
    }
}
