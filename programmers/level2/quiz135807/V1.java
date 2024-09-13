package level2.quiz135807;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/135807">숫자 카드 나누기</a>
 */
public class V1 {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = findGcd(arrayA);
        if (!isValid(gcdA, arrayB)){
            gcdA = 0;
        }
        int gcdB = findGcd(arrayB);
        if (!isValid(gcdB, arrayA)){
            gcdB = 0;
        }
        return Math.max(gcdA, gcdB);
    }
    private boolean isValid(int gcd, int[] nums) {
        if (gcd > 0) {
            for (int num : nums) {
                if (num % gcd == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // 최대공약수 구하기
    private int gcd(int num1, int num2) {
        if (num2 == 0) return num1;
        return gcd(num2, num1 % num2);
    }
    private int findGcd(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = gcd(result, nums[i]);
        }
        return result == 1 ? 0 : result;
    }
}
