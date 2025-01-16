package dynamic.medium.quiz139;

import java.util.List;

public class SolutionV2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int max_len = 0;
        for (String word : wordDict) {
            max_len = Math.max(max_len, word.length());
        }

        for (int i = 1; i <= n; i++) {
            /**
             * 불필요한 계산을 줄이기 위해 검사 범위를 제한
             * i - max_len - 1: 현재 인덱스 i에서 최대 길이 max_len만큼 거슬러 올라간 위치를 계산.
             * Math.max(..., 0): 인덱스가 음수가 되지 않도록 범위를 제한.
             */
            int max = Math.max(i - max_len - 1, 0);

            for (int j = i - 1; j >= max; j--) {
                String substring = s.substring(j, i);
                if (dp[j] && wordDict.contains(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();

        String input = "catsandog";
        List<String> wordDick = List.of("cats", "dog", "sand", "and", "cat");

        boolean answer = solution.wordBreak(input, wordDick);
        System.out.println(answer);
    }
}
