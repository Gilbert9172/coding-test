package dynamic.medium.quiz139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionV1 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && wordSet.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();

        String input = "catsandog";
        List<String> wordDick = List.of("cats", "dog", "sand", "and", "cat");

        boolean answer = solution.wordBreak(input, wordDick);
        System.out.println(answer);
    }
}
