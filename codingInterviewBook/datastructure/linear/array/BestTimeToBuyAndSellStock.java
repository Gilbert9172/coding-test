package datastructure.linear.array;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {8, 1, 5, 3, 6, 4};
        int answer = maxProfit(prices);
        System.out.println(answer);

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

}
