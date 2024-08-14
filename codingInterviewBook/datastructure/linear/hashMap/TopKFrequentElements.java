package datastructure.linear.hashMap;

import java.util.*;

public class TopKFrequentElements {

    public static class Counter implements Comparable<Counter> {
        int element;
        int count;

        public Counter(int element, int count) {
            this.element = element;
            this.count = count;
        }

        @Override
        public int compareTo(Counter other) {
            return Integer.compare(other.count, this.count);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Counter> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.keySet()) {
            pq.add(new Counter(i, map.get(i)));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) {
                return result;
            }
            Counter target = pq.poll();
            result[i] = target.element;
        }
        return result;
    }

    public static int[] topKFrequentV2(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}