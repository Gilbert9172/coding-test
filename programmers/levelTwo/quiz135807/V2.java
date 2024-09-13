package levelTwo.quiz135807;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/135807">숫자 카드 나누기</a>
 */
public class V2 {
    public static int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        PriorityQueue<Integer> result = new PriorityQueue<>(Comparator.reverseOrder());

        solve(arrayA, arrayB, new PriorityQueue<>(Comparator.reverseOrder()), result);
        solve(arrayB, arrayA, new PriorityQueue<>(Comparator.reverseOrder()), result);

        if (result.isEmpty()) {
            return 0;
        }

        return result.poll();
    }

    private static void solve(int[] arrayA, int[] arrayB, PriorityQueue<Integer> pq, PriorityQueue<Integer> result) {
        loop:
        for (int i = arrayA[0]; i > 1; i--) {
            if (!result.isEmpty() && result.peek() > i) {
                break;
            }

            for (int a : arrayA) {
                if (a % i != 0) {
                    continue loop;
                }
            }

            pq.add(i);
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();

            boolean isSuccess = true;
            for (int i : arrayB) {
                if (i % cur == 0) {
                    isSuccess = false;
                    break;
                }
            }

            if (isSuccess) {
                result.add(cur);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{12,16}, new int[]{6, 18}));
//        System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
//        System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
//        System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
    }
}