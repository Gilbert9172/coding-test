package array.medium;

public class SolutionV1 {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        int[] answer = new int[2];

        while (left < right) {
            int lowNum = numbers[left];
            int highNum = numbers[right];
            if (lowNum + highNum < target) {
                left++;
            }
            if (lowNum + highNum > target) {
                right--;
            }
            if (lowNum + highNum == target) {
                answer[0] = left + 1;
                answer[1] = right + 1;
                break;
            }
        }
        return answer;
    }
}
