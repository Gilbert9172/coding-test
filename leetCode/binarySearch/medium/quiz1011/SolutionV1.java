package binarySearch.medium.quiz1011;

public class SolutionV1 {

    public int shipWithinDays(int[] weights, int days) {

        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            int takenDays = 0;
            int currWeight = 0;
            for (int weight : weights) {
                currWeight += weight;
                if (currWeight == mid) {
                    takenDays++;
                    currWeight = 0;
                } else if (currWeight > mid) {

                    int prev = currWeight - weight;
                    takenDays += (prev + mid - 1) / mid;

                    currWeight = weight;
                }
            }

            if (currWeight != 0) {
                takenDays += (currWeight + mid - 1) / mid;
            }

            if (takenDays <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 10;

        SolutionV1 solution = new SolutionV1();
        int answer = solution.shipWithinDays(weights, days);
        System.out.println(answer);
    }
}
