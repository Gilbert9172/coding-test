package datastructure.non_linear.graph.NumberOfIslands;

public class NumberOfIslandsDFS {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i, j + 1, grid); // 동
        dfs(i, j - 1, grid); // 서
        dfs(i + 1, j, grid); // 남
        dfs(i - 1, j, grid); // 북
    }
}
