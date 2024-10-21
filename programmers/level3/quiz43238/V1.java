package level3.quiz43238;

import java.util.Arrays;

public class V1 {
    public static void main(String[] args) {
        long solution = solution(6, new int[]{7, 10});
        System.out.println(solution);
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long canTake = 0;
            for (long time : times) {
                canTake += mid / time;
            }
            if (canTake < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }
}
