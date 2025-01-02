package binarySearch.medium.quiz875;

public class SolutionV2 {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = (int) 1e9;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int takenHour = 0;
            for (int pile : piles) {
                takenHour += (pile + mid - 1) / mid;
            }

            if (takenHour <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;

        SolutionV2 solution = new SolutionV2();
        int answer = solution.minEatingSpeed(piles, h);
        System.out.println(answer);
    }
}
