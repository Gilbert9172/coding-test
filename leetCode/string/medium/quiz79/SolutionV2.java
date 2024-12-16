package string.medium.quiz79;

public class SolutionV2 {

    int maxRow;
    int maxCol;

    public boolean exist(char[][] board, String word) {
        maxRow = board.length;
        maxCol = board[0].length;
        boolean[][] visited = new boolean[maxRow][maxCol];

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (board[row][col] == word.charAt(0)) {
                    boolean result = backTracking(word, board, visited, row, col, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backTracking(String word, char[][] board, boolean[][] visited, int row, int col, int letterCount) {
        if (letterCount == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= maxRow || col >= maxCol) {
            return false;
        }

        if (visited[row][col] || board[row][col] != word.charAt(letterCount)) {
            return false;
        }

        visited[row][col] = true;
        boolean left = backTracking(word, board, visited, row, col - 1, letterCount + 1);
        boolean right = backTracking(word, board, visited, row, col + 1, letterCount + 1);
        boolean up = backTracking(word, board, visited, row - 1, col, letterCount + 1);
        boolean down = backTracking(word, board, visited, row + 1, col, letterCount + 1);

        if (left || right || up || down) {
            return true;
        }

        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        String input = "ABCESEEEFS";
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        SolutionV2 solutionV2 = new SolutionV2();
        boolean answer = solutionV2.exist(board, input);
        System.out.println(answer);
    }
}
