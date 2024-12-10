package dfs.medium.quiz695;

public class SolutionV2 {

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        int maxArea = 0;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] == 1) {
                    int area = dfs(grid, row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int currRow, int currCol) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        if (currCol < 0 || currRow < 0 || currRow >= maxRow || currCol >= maxCol || grid[currRow][currCol] == 0) {
            return 0;
        }

        grid[currRow][currCol] = 0;

        int areaSize = 1;
        for (int[] dir : dirs) {
            int nextRow = currRow + dir[0];
            int nextCol = currCol + dir[1];
            areaSize += dfs(grid, nextRow, nextCol);
        }
        return areaSize;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };
        SolutionV2 solution = new SolutionV2();
        int answer = solution.maxAreaOfIsland(grid);
        System.out.println(answer);
    }
}
