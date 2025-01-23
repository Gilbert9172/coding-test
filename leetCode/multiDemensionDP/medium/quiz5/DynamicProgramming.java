package multiDemensionDP.medium.quiz5;

public class DynamicProgramming {

    public String longestPalindrome(String s) {
        int resIdx = 0, resLen = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int k = i; k < n; k++) {
                if (s.charAt(i) == s.charAt(k) && (k - i <= 2 || dp[i + 1][k - 1])) {
                    dp[i][k] = true;
                    if (resLen < k - i + 1) {
                        resIdx = i;
                        resLen = k - i + 1;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }

    public static void main(String[] args) {
        DynamicProgramming solution = new DynamicProgramming();
        String answer = solution.longestPalindrome("abbazezalpha");
        System.out.println(answer);
    }

}
