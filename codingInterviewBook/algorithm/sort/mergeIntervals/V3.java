package algorithm.sort.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class V3 {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        for (int[] interval : intervals) {
            if (!merged.isEmpty() && interval[0] <= merged.get(merged.size() - 1)[1]) {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            } else {
                merged.add(interval);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
