package string.easy.quiz125.java;

public class SolutionV2 {
    public static void main(String[] args) {
        boolean answer = new SolutionV2().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(answer);
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !isAlphanumeric(toLowerCase(s.charAt(left)))) {
                left++;
            }
            while (left < right && !isAlphanumeric(toLowerCase(s.charAt(right)))) {
                right--;
            }

            if (toLowerCase(s.charAt(left)) != toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphanumeric(char ch) {
        return ch >= 'a' && ch <= 'z' ||
                ch >= '0' && ch <= '9';
    }

    private char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + 32);
        } else {
            return ch;
        }
    }
}
