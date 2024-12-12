package dfs.medium.quiz1254;

// DFS
public class DFS {

    public int closedIsland(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        int count = 0;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] == 0 && dfs(grid, row, col)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int row, int col) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        if (row < 0 || col < 0 || row >= maxRow || col >= maxCol) {
            return false;
        }

        if (grid[row][col] == 1) {
            return true;
        }

        grid[row][col] = 1;
        boolean left = dfs(grid, row, col - 1);
        boolean right = dfs(grid, row, col + 1);
        boolean up = dfs(grid, row - 1, col);
        boolean down = dfs(grid, row + 1, col);
        return left && right && up && down;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        DFS dfs = new DFS();
        int answer = dfs.closedIsland(grid);
        System.out.println(answer);
    }
}
