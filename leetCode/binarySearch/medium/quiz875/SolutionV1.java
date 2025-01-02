package binarySearch.medium.quiz875;

import java.util.Arrays;

public class SolutionV1 {

    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);

        int left = 0;
        int right = piles[piles.length - 1];
        int answer = piles[piles.length - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) break;

            int takenHour = 0;
            for (int pile : piles) {
                if (pile <= mid) {
                    takenHour++;
                } else {
                    takenHour += (pile / mid);
                    if (pile % mid != 0) {
                        takenHour++;
                    }
                }
            }

            if (takenHour > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] piles = {312884470};
        int h = 968709470;

        SolutionV1 solution = new SolutionV1();
        int answer = solution.minEatingSpeed(piles, h);
        System.out.println(answer);
    }
}
