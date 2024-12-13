package dfs.medium.quiz130;

public class SolutionV2 {

    private static final char WALL = 'X';
    private static final char LAND = 'O';

    public void solve(char[][] board) {
        int maxRow = board.length, maxCol = board[0].length;
        boolean[][] vis = new boolean[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                dfs(board, vis, i, 0);
            }
            if (board[i][maxCol - 1] == LAND && !vis[i][maxCol - 1]) {
                dfs(board, vis, i, maxCol - 1);
            }
        }
        for (int i = 0; i < maxCol; i++) {
            if (board[0][i] == LAND && !vis[0][i]) {
                dfs(board, vis, 0, i);
            }
            if (board[maxRow - 1][i] == LAND && !vis[maxRow - 1][i]) {
                dfs(board, vis, maxRow - 1, i);
            }
        }
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (!vis[row][col])
                    board[row][col] = WALL;
            }
        }
    }

    public void dfs(char[][] board, boolean[][] vis, int row, int col) {
        vis[row][col] = true;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (positionInRage(board, nextRow, nextCol) &&
                    isLand(board, vis, nextRow, nextCol) &&
                    visited(vis, nextRow, nextCol)) {
                dfs(board, vis, nextRow, nextCol);
            }
        }
    }

    private boolean positionInRage(char[][] board, int row, int col) {
        return row >= 0 && col >= 0 && row < board.length && col < board[0].length;
    }

    private boolean isLand(char[][] board, boolean[][] vis, int row, int col) {
        return board[row][col] == LAND;
    }

    private boolean visited(boolean[][] vis, int row, int col) {
        return !vis[row][col];
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        SolutionV2 solution = new SolutionV2();
        solution.solve(board);
    }
}
