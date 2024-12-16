package string.medium.quiz79;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int maxRow = board.length;
        int maxCol = board[0].length;

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (board[row][col] == word.charAt(0)) {
                    boolean[][] visited = new boolean[maxRow][maxCol];
                    visited[row][col] = true;
                    List<String> bucket = new ArrayList<>();
                    bucket.add(Character.toString(board[row][col]));
                    String answer = backTracking(board, visited, 1, row, col, word, bucket);
                    if (answer.equals(word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String backTracking(char[][] board, boolean[][] visited, int letterCount, int row, int col, String word, List<String> bucket) {
        int maxRow = board.length;
        int maxCol = board[0].length;

        if (letterCount == word.length()) {
            return String.join("", bucket);
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (nextRow < 0 || nextCol < 0 || nextRow >= maxRow || nextCol >= maxCol) {
                continue;
            }

            if (board[nextRow][nextCol] == word.charAt(letterCount) && !visited[nextRow][nextCol]) {
                bucket.add(Character.toString(board[nextRow][nextCol]));
                visited[nextRow][nextCol] = true;
                String path = backTracking(board, visited, letterCount + 1, nextRow, nextCol, word, bucket);
                if (path.length() == word.length()) {
                    return path;
                }
                bucket.removeLast();
                visited[nextRow][nextCol] = false;

            }
        }
        return "";
    }

    public static void main(String[] args) {
        String input = "ABCESEEEFS";
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        boolean exist = solution.exist(board, input);
        System.out.println(exist);
    }
}
