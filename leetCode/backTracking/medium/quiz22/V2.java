package backTracking.medium.quiz22;

import java.util.ArrayList;
import java.util.List;

public class V2 {

    List<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTracking(n, 0, 0, "");
        return answer;
    }

    private void backTracking(
            int n,
            int openCount,
            int closeCount,
            String builder
    ) {
        if (openCount == n && closeCount == n) {
            answer.add(builder);
            return;
        }

        if (openCount < n) {
            backTracking(n, openCount + 1, closeCount, builder + "(");
        }

        if (openCount > closeCount) {
            backTracking(n, openCount, closeCount + 1, builder + ")");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        V2 v2 = new V2();
        List<String> answers = v2.generateParenthesis(n);
        for (String answer : answers) {
            System.out.println(answer);
        }
    }
}
