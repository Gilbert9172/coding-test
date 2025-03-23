package dynamic.medium.quiz1143;

public class JavaSolutionV1 {
    public int longestCommonSubsequence(String text1, String text2) {
        int maxRow = text1.length();
        int maxCol = text2.length();

        int[][] memo = new int[maxRow + 1][maxCol + 1];

        for (int r = 1; r <= maxRow; r++) {
            for (int c = 1; c <= maxCol; c++) {
                if (text1.charAt(r - 1) == text2.charAt(c - 1)) {
                    memo[r][c] = memo[r - 1][c - 1] + 1;
                } else {
                    memo[r][c] = Math.max(memo[r - 1][c], memo[r][c - 1]);
                }
            }
        }

        return memo[maxRow][maxCol];
    }
}
