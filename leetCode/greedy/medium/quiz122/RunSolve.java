package greedy.medium.quiz122;

public class RunSolve {
    public static void main(String[] args) {
        V2 solution = new V2();
        int[] input1 = {7, 1, 5, 3, 6, 4};
        int[] input2 = {7, 1, 5, 7, 3, 6, 4};
        int[] input3 = {1, 2, 3, 4, 5, 6, 7};
        int[] input4 = {7, 6, 5, 4, 3, 2, 1};

        System.out.println(solution.maxProfit(input1));
        System.out.println(solution.maxProfit(input2));
        System.out.println(solution.maxProfit(input3));
        System.out.println(solution.maxProfit(input4));
    }
}
