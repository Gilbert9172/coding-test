package algorithm.binrySearch.search2dMatrix;

public class RunSolve {
    public static void main(String[] args) {
        V3 solution = new V3();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 30;
        boolean answer = solution.searchMatrix(matrix, target);
        System.out.println(answer);
    }
}
