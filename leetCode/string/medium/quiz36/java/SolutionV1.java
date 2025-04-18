package string.medium.quiz36.java;

public class SolutionV1 {
    public static void main(String[] args) {

        char[][] board = new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        new SolutionV1().isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {
        // 9개의 행, 열, 박스를 위한 boolean 배열
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // 모든 셀 순회
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char value = board[r][c];

                // 숫자가 아니라면 무시
                if (value == '.') continue;

                int num = value - '1'; // 숫자 '1'~'9' → 인덱스 0~8
                int boxIndex = (r / 3) * 3 + (c / 3); // 3x3 박스 인덱스 계산

                // 이미 해당 숫자가 존재하는 경우 false
                if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                    return false;
                }

                // 방문 기록
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true;
    }
}
