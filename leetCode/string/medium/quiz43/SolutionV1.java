package string.medium.quiz43;

// 43. Multiply strings
public class SolutionV1 {
    public String multiply(String num1, String num2) {

        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Input numbers are invalid");
        }

        int m = num1.length();
        int n = num2.length();

        if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }

        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int multiplied = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                multiplied += result[i + j + 1];
                result[i + j + 1] = multiplied % 10;
                result[i + j] += multiplied / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (sb.isEmpty() && num == 0) {
                continue;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        String answer = solution.multiply("123", "45");
        System.out.println(answer);
    }

}
