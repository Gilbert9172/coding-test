package greedy.jumpGame;

public class RunSolve {
    public static void main(String[] args) {
        JumpGame solve = new JumpGame();
        int[] case1 = {2, 3, 1, 1, 4};
        int[] case2 = {3 ,2, 1, 0, 4};
        int[] case3 = {4, 1, 3};
        int[] case4 = {2, 0};
        int[] case5 = {1, 2, 3};
        boolean answer1 = solve.canJump(case1);
        boolean answer2 = solve.canJump(case2);
        boolean answer3 = solve.canJump(case3);
        boolean answer4 = solve.canJump(case4);
        boolean answer5 = solve.canJump(case5);
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
        System.out.println(answer4);
        System.out.println(answer5);
    }
}
