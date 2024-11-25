package backTracking.medium.quiz842;

import java.util.ArrayList;
import java.util.List;

// [LeetCode#842] Split Array into Fibonacci Sequence
public class V1 {

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
            List<String> bucket
    ) {
        if (cursor >= num.length() && bucket.size() >= 3 && isFibonacciSeq(bucket)) {
            List<Integer> source = convertToIntegerList(bucket);
            fibonacciSequences.add(source);
        }

        if (fibonacciSequences.size() == 1) {
            return;
        }

        for (int idx = cursor; idx < num.length(); idx++) {
            String sub = num.substring(cursor, idx + 1);
            if (hasLeadingZero(sub)) break;
            bucket.add(sub);
            backTracking(num, cursor + sub.length(), bucket);
            bucket.removeLast();
        }
    }

    private boolean isFibonacciSeq(List<String> bucket) {
        List<Integer> source = convertToIntegerList(bucket);

        int cursor = 2;
        while (cursor < bucket.size()) {
            Integer left = source.get(cursor - 2);
            Integer right = source.get(cursor - 1);
            Integer expected = source.get(cursor);
            if (left + right != expected) {
                return false;
            }
            cursor++;
        }
        return true;
    }

    private List<Integer> convertToIntegerList(List<String> bucket) {
        return bucket.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private boolean hasLeadingZero(String source) {
        return source.charAt(0) == '0' && source.length() != 1;
    }

    public static void main(String[] args) {
        V1 v1 = new V1();
        List<Integer> answers = v1.splitIntoFibonacci("214748364221474836419999");
    }
}
