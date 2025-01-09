package array.medium.quiz122;

public class SolutionV1 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int idx = 0; idx < prices.length - 1; idx++) {
            int today = prices[idx];
            int tomorrow = prices[idx + 1];
            if (today < tomorrow) {
                profit += tomorrow - today;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        SolutionV1 solution = new SolutionV1();
        int answer = solution.maxProfit(prices);
        System.out.println(answer);
    }
}
