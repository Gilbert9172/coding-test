package string.medium.quiz151;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionV1 {

    public String reverseWords(String s) {
        String preprocessed = preprocessingInput(s);

        char[] charArray = preprocessed.toCharArray();
        Deque<Character> dq = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            char target = charArray[i];
            if ((int) target == 32) {
                while (!dq.isEmpty()) {
                    sb.append(dq.pollFirst());
                }
                sb.append(' ');
            } else {
                dq.addFirst(target);
            }
        }

        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }

    private String preprocessingInput(String input) {
        return input.trim()
                .replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        String s = "  the  sky  is    blue  ";

        SolutionV1 solution = new SolutionV1();
        String answer = solution.reverseWords(s);
        System.out.println(answer);
    }

}
