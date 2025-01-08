package array.medium.quiz167;

public class Test {

    private static final SolutionV1 solution = new SolutionV1();

    private static void case1() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] answer = solution.twoSum(numbers, target);
        printAnswer(answer);
    }

    private static void case2() {
        int[] numbers = {2, 3, 4};
        int target = 6;

        int[] answer = solution.twoSum(numbers, target);
        printAnswer(answer);
    }

    private static void case3() {
        int[] numbers = {-1, 0};
        int target = -1;

        int[] answer = solution.twoSum(numbers, target);
        printAnswer(answer);
    }

    private static void printAnswer(int[] answer) {
        System.out.println("[" + answer[0] + "," + answer[1] + "]");
    }

    public static void main(String[] args) {
        case1();
        case2();
        case3();
    }

}
