package interval.hard.quiz1851;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JavaSolutionV1 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                new int[]{1, 4},
                new int[]{2, 4},
                new int[]{3, 6},
                new int[]{4, 4}
        };

        int[] queries = new int[]{2, 3, 4, 5};

        int[] answer = new JavaSolutionV1().minInterval(intervals, queries);
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length, m = queries.length;
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[0]);

        Arrays.sort(intervals, comparator);

        int[][] qs = new int[m][2];
        for (int i = 0; i < m; ++i) {
            qs[i] = new int[]{queries[i], i};
        }
        Arrays.sort(qs, comparator);

        int[] ans = new int[m];
        Arrays.fill(ans, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);

        int i = 0;
        for (int[] q : qs) {
            while (i < n && intervals[i][0] <= q[0]) {
                int a = intervals[i][0], b = intervals[i][1];
                pq.offer(new int[]{b - a + 1, b});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < q[0]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans[q[1]] = pq.peek()[0];
            }
        }
        return ans;
    }
}
