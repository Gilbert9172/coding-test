package binarySearch.medium.quiz1631;

import java.util.Arrays;

// Binary Search & DFS
public class SolutionV2 {
    private boolean[][] visited;  // Visited cells tracker
    private final int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int maxRow, maxCol;  // Number of rows and columns in the matrix

    public int minimumEffortPath(int[][] heights) {
        maxRow = heights.length;
        maxCol = heights[0].length;

        // Initialize visited array
        visited = new boolean[maxRow][maxCol];

        // Bound for our binary search
        int lowerLimit = 0, upperLimit = 1_000_000;

        while (lowerLimit < upperLimit) {
            int mid = (upperLimit + lowerLimit) / 2;
            for (boolean[] row : visited) {
                Arrays.fill(row, false);
            }

            dfs(0, 0, mid, heights);

            if (visited[maxRow - 1][maxCol - 1])
                upperLimit = mid;
            else
                lowerLimit = mid + 1;
        }

        return lowerLimit;
    }

    private void dfs(int row, int col, int limitEffort, int[][] heights) {
        if (visited[row][col]) return;
        visited[row][col] = true;

        if (row == maxRow - 1 && col == maxCol - 1) return;

        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (nextRow < 0 || nextRow >= maxRow || nextCol < 0 || nextCol >= maxCol) continue;

            int newEffort = Math.abs(heights[row][col] - heights[nextRow][nextCol]);
            if (newEffort <= limitEffort) {
                dfs(nextRow, nextCol, limitEffort, heights);
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5},
        };
        SolutionV2 solution = new SolutionV2();
        int answer = solution.minimumEffortPath(heights);
        System.out.println(answer);
    }
}
