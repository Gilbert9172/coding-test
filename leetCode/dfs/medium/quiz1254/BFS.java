package dfs.medium.quiz1254;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public int closedIsland(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int closedIslands = 0;

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] == 0 && bfs(grid, row, col)) {
                    closedIslands++;
                }
            }
        }
        return closedIslands;
    }

    private boolean bfs(int[][] grid, int row, int col) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = 1;
        boolean isClosed = true;

        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int[] currPosition = queue.poll();
            int curRow = currPosition[0], curCol = currPosition[1];

            for (int[] dir : dirs) {
                int nextRow = curRow + dir[0], nextCol = curCol + dir[1];

                if (nextRow < 0 || nextCol < 0 || nextRow >= maxRow || nextCol >= maxCol) {
                    isClosed = false;
                    continue;
                }

                if (grid[nextRow][nextCol] == 0) {
                    queue.offer(new int[]{nextRow, nextCol});
                    grid[nextRow][nextCol] = 1;
                }
            }
        }
        return isClosed;
    }

    public static void main(String[] args) {
        BFS solution = new BFS();
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println("Number of closed islands: " + solution.closedIsland(grid));
    }
}
