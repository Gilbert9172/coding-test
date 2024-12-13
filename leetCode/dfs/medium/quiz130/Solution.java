package dfs.medium.quiz130;

import java.util.LinkedList;
import java.util.Queue;

// 130. Surrounded Regions
public class Solution {

    private static final char WALL = 'X';
    private static final char LAND = 'O';
    private static final Queue<int[]> q = new LinkedList<>();

    public void solve(char[][] board) {
        int maxRow = board.length;
        int maxCol = board[0].length;
        boolean[][] visited = new boolean[maxRow][maxCol];

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (board[row][col] == LAND && !visited[row][col]) {
                    q.clear();
                    if (!(dfs(board, visited, row, col))) {
                        while (!q.isEmpty()) {
                            int[] poll = q.poll();
                            board[poll[0]][poll[1]] = LAND;
                        }
                    }
                }
            }
        }
    }

    private boolean dfs(char[][] board, boolean[][] visited, int row, int col) {
        int maxRow = board.length;
        int maxCol = board[0].length;

        if (row < 0 || col < 0 || row >= maxRow || col >= maxCol) {
            return false;
        }

        if (board[row][col] == WALL) {
            return true;
        }

        q.offer(new int[]{row, col});
        board[row][col] = WALL;
        visited[row][col] = true;
        boolean left = dfs(board, visited, row, col - 1);
        boolean right = dfs(board, visited, row, col + 1);
        boolean up = dfs(board, visited, row - 1, col);
        boolean down = dfs(board, visited, row + 1, col);
        return left && right && up && down;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        Solution solution = new Solution();
        solution.solve(board);
    }
}
