package multiDemensionDP.medium.quiz5;

public class BruteForce {

    public String longestPalindrome(String s) {
        String answer = "";
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int k = i; k < s.length(); k++) {
                int left = i, right = k;
                while (left < right && s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                }
                if (left >= right && maxLen < k - i + 1) {
                    answer = s.substring(i, k + 1);
                    maxLen = k - i + 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        BruteForce solution = new BruteForce();
        String answer = solution.longestPalindrome("abbazezalpha");
        System.out.println(answer);
    }

}
