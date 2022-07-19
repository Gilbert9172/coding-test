package levelOne;

/**
 * Summer/Winter Coding
 * 소수 만들기
 */
public class quiz09 {

    static int cnt = 0;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(countPossiblePrimeNum(nums));

    }

    //1. 서로 다른 세 수의 합
    public static Integer countPossiblePrimeNum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (isPrimeNum(num)) {
                        cnt ++;
                    }
                }
            }
        }
        return cnt;
    }

    // 2. 소수 여부 확인.
    public static boolean isPrimeNum(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
