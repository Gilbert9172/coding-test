package greedy.medium.quiz11;

public class Solution {

    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (left < right) {
            int area = calculate(left, right, heights);
            maxArea = Math.max(area, maxArea);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    private int calculate(int left, int right, int[] heights) {
        int bottom = right - left;
        int height = Math.min(heights[right], heights[left]);
        return bottom * height;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int answer = solution.maxArea(heights);
        System.out.println(answer);
    }
}
