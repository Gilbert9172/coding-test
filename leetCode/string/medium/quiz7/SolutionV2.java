package string.medium.quiz7;

public class SolutionV2 {

    public int reverse(int x) {
        long result = 0;

        while (x != 0) {
            int digit = x % 10;
            result = result * 10 + digit;
            x = x / 10;
        }

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        SolutionV2 v2 = new SolutionV2();
        int answer = v2.reverse(-130);
        System.out.println(answer);
    }
}
