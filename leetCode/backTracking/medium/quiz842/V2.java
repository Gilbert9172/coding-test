package backTracking.medium.quiz842;

import java.util.ArrayList;
import java.util.List;

// [LeetCode#842] Split Array into Fibonacci Sequence
public class V2 {

    List<List<Integer>> fibonacciSequences = new ArrayList<>();

    public List<Integer> splitIntoFibonacci(String num) {
        backTracking(num, 0, new ArrayList<>());
        return fibonacciSequences.stream()
                .findFirst()
                .orElse(List.of());
    }

    public void backTracking(
            String num,
            int cursor,
            List<Integer> bucket
    ) {
        if (cursor >= num.length() && bucket.size() >= 3) {
            fibonacciSequences.add(new ArrayList<>(bucket));
            return;
        }

        for (int idx = cursor; idx < num.length(); idx++) {
            String sub = num.substring(cursor, idx + 1);
            if (hasLeadingZero(sub)) break;

            long current = Long.parseLong(sub);
            int MAX_INT = Integer.MAX_VALUE;
            if (current > MAX_INT) break;

            int size = bucket.size();
            if (size >= 2) {
                long sum = (long) bucket.get(size - 2) + bucket.get(size - 1);
                if (current < sum) continue;
                if (current > sum) break;
            }

            bucket.add(Integer.parseInt(sub));
            backTracking(num, idx + 1, bucket);
            bucket.removeLast();
        }
    }

    private boolean hasLeadingZero(String source) {
        return source.charAt(0) == '0' && source.length() != 1;
    }

    public static void main(String[] args) {
        V2 v1 = new V2();
        List<Integer> answers = v1.splitIntoFibonacci("1101111");
        for (Integer answer : answers) {
            System.out.println(answer);
        }
    }
}
