package algorithm.sort.mergeIntervals;

public class RunSolve {
    public static void main(String[] args) {
        V1 solution = new V1();
        int[][] intervals = {
                {1, 4},
                {0, 0}
        };
        int[][] answers = solution.merge(intervals);
        for (int[] answer : answers) {
            System.out.print(answer[0]);
            System.out.print(", ");
            System.out.print(answer[1]);
            System.out.println();
        }
    }
}
