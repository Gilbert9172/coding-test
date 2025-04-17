package string.easy.quiz125.java;

public class SolutionV1 {
    public static void main(String[] args) {
        boolean answer = new SolutionV1().isPalindrome("0P");
        System.out.println(answer);
    }

    public boolean isPalindrome(String s) {
        String cleanedInput = doCleaning(s);
        int n = cleanedInput.length();

        for (int i = 0; i < n / 2; i++) {
            if (cleanedInput.charAt(i) != cleanedInput.charAt(n - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    private String doCleaning(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c - 'a' < 26 && c - 'a' >= 0) || (c - 'A' < 26 && c - 'A' >= 0) || (c > 47 && c < 58)) {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase();
    }
}
