package dynamic.medium.quiz322;

// DP without initiating DP Array
// dp status: dp[price] = the least coin counts
// dp equation: dp[i] = Math.min(dp[i-coin]) + 1 for each coin ∈ coins if i = coin >= 0
public class DpSolutionV2 {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = dp.length;
            for (int coin : coins) {
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

        DpSolutionV2 dp = new DpSolutionV2();
        int answer = dp.coinChange(coins, amount);
        System.out.println(answer);
    }
}
