package backTracking.easy.quiz401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {

    private final List<Integer> hours = new ArrayList<>(Arrays.asList(8, 4, 2, 1));
    private final List<Integer> mins = new ArrayList<>(Arrays.asList(32, 16, 8, 4, 2, 1));
    private final List<String> answer = new ArrayList<>();

    public List<String> readBinaryWatch(int turnedOn) {
        for (int i = 0; i <= turnedOn; i++) {
            List<String> hourCombinations = getHourCombinations(i);
            List<String> minCombinations = getMinCombinations(turnedOn - i);
            generateResult(hourCombinations, minCombinations);
        }
        return answer;
    }

    private void generateResult(List<String> hourCombinations, List<String> minCombinations) {
        for (String hourCombination : hourCombinations) {
            for (String minCombination : minCombinations) {
                String time = String.format("%s:%s", hourCombination, minCombination);
                answer.add(time);
            }
        }
    }

    private List<String> getHourCombinations(int elementCount) {
        List<String> answer = new ArrayList<>();
        generateHourCombination(elementCount, new ArrayList<>(), 0, answer);
        return answer;
    }

    private void generateHourCombination(int elementCount, List<Integer> bucket, int startIdx, List<String> answer) {
        if (bucket.size() == elementCount) {
            int sum = bucket.stream().mapToInt(Integer::intValue).sum();
            if (sum < 12) {
                answer.add(String.valueOf(sum));
            }
        }
        for (int i = startIdx; i < hours.size(); i++) {
            bucket.add(hours.get(i));
            generateHourCombination(elementCount, bucket, i + 1, answer);
            bucket.removeLast();
        }
    }

    private List<String> getMinCombinations(int elementCount) {
        List<String> answer = new ArrayList<>();
        generateMinCombination(elementCount, new ArrayList<>(), 0, answer);
        return answer;
    }

    private void generateMinCombination(int elementCount, List<Integer> bucket, int startIdx, List<String> answer) {
        if (bucket.size() == elementCount) {
            int sum = bucket.stream().mapToInt(Integer::intValue).sum();
            if (sum < 60) {
                if (sum < 10) {
                    answer.add(String.format("0%d", sum));
                } else {
                    answer.add(String.valueOf(sum));
                }
            }
        }
        for (int i = startIdx; i < mins.size(); i++) {
            bucket.add(mins.get(i));
            generateMinCombination(elementCount, bucket, i + 1, answer);
            bucket.removeLast();
        }
    }

    public static void main(String[] args) {
        V1 v1 = new V1();
        v1.readBinaryWatch(9);
    }
}
