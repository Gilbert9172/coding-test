package dfs.medium.quiz130;

public class SolutionV2 {

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !vis[i][0])
                dfs(board, vis, i, 0);
            if (board[i][n - 1] == 'O' && !vis[i][n - 1])
                dfs(board, vis, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O' && !vis[0][i])
                dfs(board, vis, 0, i);
            if (board[m - 1][i] == 'O' && !vis[m - 1][i])
                dfs(board, vis, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] board, boolean[][] vis, int r, int c) {
        vis[r][c] = true;
        int[] rd = {-1, 0, 1, 0};
        int[] cd = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int row = rd[i] + r;
            int col = cd[i] + c;
            if (row >= 0 && col >= 0 &&
                    row < board.length && col < board[0].length &&
                    board[row][col] == 'O' && !vis[row][col]) {
                dfs(board, vis, row, col);
            }
        }
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
