package algorithm.sort.mergeIntervals;

import java.util.*;

public class V2 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> result = new ArrayList<>();

        int[] currInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (currInterval[1] >= nextInterval[0]) {
                currInterval[1] =  Math.max(currInterval[1], nextInterval[1]);
            } else {
                result.add(currInterval);
                currInterval = nextInterval;
            }
        }
        result.add(currInterval);
        return result.toArray(new int[result.size()][2]);
    }
}
