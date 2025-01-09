package memoization;

import java.util.Arrays;

public class TopDown {

    private static int[] memo;

    public int fibonacci(int n) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];
        return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        memo = new int[n + 1];
        Arrays.fill(memo, -1); // 메모이제이션 배열 초기화

        TopDown topDown = new TopDown();
        topDown.fibonacci(n);
    }
}
