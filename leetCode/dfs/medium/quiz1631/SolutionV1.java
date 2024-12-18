package dfs.medium.quiz1631;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 다익스트라
public class SolutionV1 {

    private final int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int maxRow;
    private int maxCol;

    public int minimumEffortPath(int[][] heights) {
        maxRow = heights.length;
        maxCol = heights[0].length;

        int[][] efforts = new int[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) Arrays.fill(efforts[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});
        efforts[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int effort = top[0], row = top[1], col = top[2];

            if (row == maxRow - 1 && col == maxCol - 1) return effort;

            for (int[] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow < 0 && nextRow >= maxRow && nextCol < 0 && nextCol >= maxCol) continue;

                int newEffort = Math.max(effort, Math.abs(heights[nextRow][nextCol] - heights[row][col]));
                if (efforts[nextRow][nextCol] > newEffort) {
                    efforts[nextRow][nextCol] = newEffort;
                    pq.offer(new int[]{efforts[nextRow][nextCol], nextRow, nextCol});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5},
        };
        SolutionV1 solution = new SolutionV1();
        int answer = solution.minimumEffortPath(heights);
        System.out.println(answer);
    }
}
