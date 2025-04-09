package array.medium.quiz347;

import java.util.*;

public class JavaSolutionV1 {

    public static class Frequent {
        int num;
        int count;

        public Frequent(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) return new int[]{};

        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int num : nums) {
            counterMap.put(num, counterMap.getOrDefault(num, 0) + 1);
        }

        Comparator<Frequent> comparing = Comparator.comparing((Frequent a) -> a.count).reversed();
        PriorityQueue<Frequent> pq = new PriorityQueue<>(comparing);

        List<Frequent> frequents = counterMap.entrySet()
                .stream()
                .map(it -> new Frequent(it.getKey(), it.getValue()))
                .toList();

        pq.addAll(frequents);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().num);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
