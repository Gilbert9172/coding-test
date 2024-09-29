package algorithm.sort.largestNumber;

public class RunSolve {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 8, 9};
        V1 solution = new V1();
        String answer = solution.largestNumber(nums);
        System.out.println(answer);
    }
}
