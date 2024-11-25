package backTracking.medium.quiz842;

import java.util.ArrayList;
import java.util.List;

/**
 * V2과 V3의 콜라보
 */
public class V4 {

    List<List<Integer>> fibonacciSequences = new ArrayList<>();

    public List<Integer> splitIntoFibonacci(String num) {
        backTracking(num.toCharArray(), 0, new ArrayList<>());
        return fibonacciSequences.stream()
                .findFirst()
                .orElse(List.of());
    }

    public void backTracking(
            char[] digits,
            int cursor,
            List<Integer> bucket
    ) {
        if (cursor >= digits.length && bucket.size() >= 3) {
            fibonacciSequences.add(new ArrayList<>(bucket));
            return;
        }

        if (fibonacciSequences.size() == 1) {
            return;
        }

        for (int idx = cursor; idx < digits.length; idx++) {
            // 시작점(cursor) 보다 idx가 큰 경우 (111, 101, 01)
            if (digits[cursor] == '0' && idx > cursor) break;

            long subDigit = subDigit(digits, cursor, idx + 1);

            if (subDigit > Integer.MAX_VALUE) break;

            int size = bucket.size();
            if (size >= 2) {
                long sum = (long) bucket.get(size - 2) + bucket.get(size - 1);
                if (subDigit < sum) continue;
                if (subDigit > sum) break;
            }

            bucket.add((int) subDigit);
            backTracking(digits, idx + 1, bucket);
            bucket.removeLast();
        }
    }

    private long subDigit(char[] digits, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + digits[i] - '0';
        }
        return res;
    }


    public static void main(String[] args) {
        V4 v1 = new V4();
        List<Integer> answers = v1.splitIntoFibonacci("1101111");
        for (Integer element : answers) {
            System.out.println(element);
        }
    }
}
