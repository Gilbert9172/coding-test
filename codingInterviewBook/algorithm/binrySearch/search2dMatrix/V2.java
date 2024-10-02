package algorithm.binrySearch.search2dMatrix;

// row & col
public class V2 {
    public boolean searchMatrix(int[][] matrix, int target) {
       int row = 0;
       int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                col --;
            } else if (matrix[row][col] < target) {
                row ++;
            } else {
                return false;
            }
        }
        return true;
    }
}
