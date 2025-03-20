package greedy.medium.quiz122;

public class V2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int dailyProfit = prices[i] - prices[i - 1];
            if (dailyProfit > 0) {
                maxProfit += dailyProfit;
            }
        }
        return maxProfit;
    }
}
