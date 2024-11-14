package algorithm.sliding_window.slidingWindowMaximum;

public class Application {
    public static void main(String[] args) {
        V3 solution = new V3();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] answer = solution.maxSlidingWindow(nums, k);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
