package dynamic.medium.quiz152;

public class SolutionV1 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // 초기값 설정
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        // 배열 순회
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // 음수를 만나면 max와 min을 스왑
            if (num < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // 현재 숫자를 포함한 최대/최소값 갱신
            maxProduct = Math.max(num, maxProduct * num);
            minProduct = Math.min(num, minProduct * num);

            // 최대값 갱신
            result = Math.max(result, maxProduct);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 0, 1, -2};

        SolutionV1 solution = new SolutionV1();
        int answer = solution.maxProduct(nums);
        System.out.println(answer);
    }
}
