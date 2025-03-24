package devsisters;

import java.util.Arrays;

public class Note1 {

    private static int[] points = {1, 5, 50, 100};

    public int solution(int score) {

        int[] memo = new int[score + 1];
        Arrays.fill(memo, score + 1);
        memo[0] = 0;

        for (int i = 1; i <= score; i++) {
            for (int point : points) {
                if (i - point >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - point] + 1);
                }
            }
        }

        return memo[score];
    }
}
