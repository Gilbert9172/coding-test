package array.medium.quiz238;

public class JavaSolution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] results = productExceptSelf(nums);
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int prev = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prev;   // 현재 위치의 왼쪽 곱셈 결과 저장
            prev *= nums[i];    // p에 현재 값 곱하기 (다음 위치에서 사용)
        }

        prev = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= prev; // 오른쪽 값을 곱함
            prev *= nums[i];   // p 업데이트
        }

        return result;
    }
}
