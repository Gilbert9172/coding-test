package dfs.medium.quiz695;

public class Solution {

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        boolean[][] visited = new boolean[maxRow][maxCol];

        int maxArea = 0;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    int area = dfs(grid, visited, row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, boolean[][] visited, int currRow, int currCol) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        if (currCol < 0 || currRow < 0 || currRow >= maxRow || currCol >= maxCol || grid[currRow][currCol] == 0 || visited[currRow][currCol]) {
            return 0;
        }

        visited[currRow][currCol] = true;

        int areaSize = 1;
        for (int[] dir : dirs) {
            int nextRow = currRow + dir[0];
            int nextCol = currCol + dir[1];
            areaSize += dfs(grid, visited, nextRow, nextCol);
        }
        return areaSize;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };
        Solution solution = new Solution();
        int answer = solution.maxAreaOfIsland(grid);
        System.out.println(answer);
    }
}
