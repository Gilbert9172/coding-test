package algorithm.binrySearch.twoSum2;

public class RunSolve {
    public static void main(String[] args) {
        V3 solution = new V3();
        int[] numbers = {1,2,3,4,5,7};
        int[] answer = solution.twoSum(numbers, 9);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}

