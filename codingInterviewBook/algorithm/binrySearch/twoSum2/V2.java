package algorithm.binrySearch.twoSum2;

/**
 * Two Pointer - O(N)
 * target 보다 합이 작으면 left ++;
 * target 보다 합이 크면 right --;
 */
public class V2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left != right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                answer[0] = left + 1;
                answer[1] = right + 1;
                break;
            }
            if (sum < target) {
                left ++;
            }
            if (sum > target) {
                right --;
            }
        }
        return answer;
    }
}