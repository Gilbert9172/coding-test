package dynamic.medium.quiz322;

import java.util.Arrays;

public class DfsSolution {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        memo[0] = 0;
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (memo[amount] != -2) return memo[amount];

        int minCoin = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = dfs(coins, amount - coin, memo);
            if (result >= 0) {
                minCoin = Math.min(minCoin, result + 1);
            }
        }
        memo[amount] = (minCoin == Integer.MAX_VALUE) ? -1 : minCoin;
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2, 5, 10, 1};
        int amount = 27;

        DfsSolution dfs = new DfsSolution();
        int answer = dfs.coinChange(coins, amount);
        System.out.println(answer);
    }
}
