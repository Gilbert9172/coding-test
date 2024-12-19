package greedy.medium.quiz11;

public class SolutionV1 {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int x = right - left;
            int y = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, x * y);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        SolutionV1 sol = new SolutionV1();
        int answer = sol.maxArea(heights);
        System.out.println(answer);
    }
}
