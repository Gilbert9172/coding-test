package backTracking.medium.quiz22;

import java.util.ArrayList;
import java.util.List;

public class V1 {

    List<String> answer = new ArrayList<>();
    List<String> letters = List.of("(", ")");

    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        builder.append(letters.getFirst());
        backTracking(n, 1, 0, builder);
        return answer;
    }

    private void backTracking(
            int n,
            int openCount,
            int closeCount,
            StringBuilder builder
    ) {
        if (openCount > n || closeCount > n || openCount < closeCount) {
            return;
        }
        if (openCount == n && closeCount == n) {
            answer.add(builder.toString());
            return;
        }
        for (int i = 0; i < 2; i++) {
            String letter = letters.get(i);
            if (letter.equals("(")) {
                openCount++;
                builder.append(letter);
            }
            if (letter.equals(")")) {
                closeCount++;
                builder.append(letter);
            }
            backTracking(n, openCount, closeCount, builder);

            char removeTargetIdx = builder.charAt(builder.length() - 1);
            if (removeTargetIdx == '(') {
                openCount--;
            }
            if (removeTargetIdx == ')') {
                closeCount--;
            }
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        V1 v1 = new V1();
        List<String> answers = v1.generateParenthesis(n);
        for (String answer : answers) {
            System.out.println(answer);
        }
    }
}
