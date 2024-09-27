package algorithm.sort.mergeIntervals;

import java.util.*;

public class V1 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        Deque<int[]> q = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        for (int[] interval : intervals) {
            q.offer(interval);
        }
        List<int[]> result = new ArrayList<>();
        while (q.size() > 1) {
            int[] interval1 = q.pollFirst();
            int[] interval2 = q.pollFirst();
            if (interval2 != null && interval1[1] >= interval2[0]) {
                q.addFirst(new int[]{interval1[0], Math.max(interval1[1], interval2[1])});
            } else {
                result.add(interval1);
                q.addFirst(interval2);
            }
        }
        result.add(q.remove());
        return result.toArray(new int[result.size()][2]);
    }
}
