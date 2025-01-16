package dynamic.medium.quiz152;

public class SolutionV2 {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int left = 1, right = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {

            //if any of l or r become 0 then update it to 1
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;

            left *= nums[i];   //prefix product
            right *= nums[n - 1 - i];    //suffix product

            ans = Math.max(ans, Math.max(left, right));

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 0, 1, -2};

        SolutionV2 solution = new SolutionV2();
        int answer = solution.maxProduct(nums);
        System.out.println(answer);
    }
}
