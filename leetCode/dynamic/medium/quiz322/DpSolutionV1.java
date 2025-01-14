package dynamic.medium.quiz322;

import java.util.Arrays;

public class DpSolutionV1 {

    public int coinChange(int[] coins, int amount) {

        // STEP 1 : DP 배열 초기화
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // STEP 2 : i원을 만들 수 있는 조합 찾기
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // STEP 3 : [i - coin]을 만들었던 갯수를 더해서 현재 i를 만들 수 있는 최소 동전의 수 구하기
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2, 5, 10, 1};
        int amount = 27;

        DpSolutionV1 dp = new DpSolutionV1();
        int answer = dp.coinChange(coins, amount);
        System.out.println(answer);
    }
}
