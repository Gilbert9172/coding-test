package memoization;

public class BottomUp {

    public int fibonacci(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        BottomUp bottomUp = new BottomUp();
        int answer = bottomUp.fibonacci(10);
        System.out.println(answer);
    }
}
