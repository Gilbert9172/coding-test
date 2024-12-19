package greedy.medium.quiz2517;

import java.util.Arrays;

// Binary Search + Greedy + Sort
public class SolutionV1 {

    public int maximumTastiness(int[] price, int k) {

        Arrays.sort(price);

        int left = 0;
        int right = price[price.length - 1] - price[0];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(price, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private boolean isValid(int[] price, int k, int mid) {
        int count = 1;
        int prev = price[0];

        for (int i = 1; i < price.length; i++) {
            if (price[i] - prev >= mid) {
                count++;
                prev = price[i];
                if (count == k) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SolutionV1 sol = new SolutionV1();
        int[] prices = new int[]{13, 5, 1, 8, 21, 2};
        int answer = sol.maximumTastiness(prices, 3);
        System.out.println(answer);
    }
}
