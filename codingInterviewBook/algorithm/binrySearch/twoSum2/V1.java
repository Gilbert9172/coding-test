package algorithm.binrySearch.twoSum2;

// Two Pointer - O(N²)
public class V1 {
    public int[] twoSum(int[] numbers, int target) {
        boolean finished = false;
        int[] answer = new int[2];
        for (int i = 1; i < numbers.length; i++) {
            int left = i - 1;
            int right = i;
            while (right < numbers.length) {
                if (numbers[left] + numbers[right] == target) {
                    finished = true;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                    break;
                }
                right++;
            }
            if (finished) {
                break;
            }
        }
        return answer;
    }
}