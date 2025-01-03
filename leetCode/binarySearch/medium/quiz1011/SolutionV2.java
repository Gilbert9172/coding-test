package binarySearch.medium.quiz1011;

public class SolutionV2 {

    public int shipWithinDays(int[] weights, int days) {

        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (check(mid, weights, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int max, int[] weights, int days) {
        int curr = 0;
        int count = 1;
        for (int weight : weights) {
            curr += weight;
            if (curr > max) {
                curr = weight;
                count++;
            }
        }
        return count <= days;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 10;

        SolutionV2 solution = new SolutionV2();
        int answer = solution.shipWithinDays(weights, days);
        System.out.println(answer);
    }
}
