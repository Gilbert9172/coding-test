package slidingWindow;

public class Quiz424 {
    public int characterReplacement(String s, int k) {
        int[] countMap = new int[26];
        int left = 0;
        int maxCount = 0;
        int longest = 0;

        for (int right = 0; right < s.length(); right++) {
            int charAtRightCursor = s.charAt(right) - 'A';
            countMap[charAtRightCursor]++;
            maxCount = Math.max(maxCount, countMap[charAtRightCursor]);

            while ((right - left + 1) - maxCount > k) {
                int charAtLeftCursor = s.charAt(left) - 'A';
                countMap[charAtLeftCursor]--;
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        Quiz424 quiz424 = new Quiz424();
        String s = "AAABBCD";
        int k = 2;
        int answer = quiz424.characterReplacement(s, k);
        String message = String.format("정답 : %d", answer);
        System.out.println(message);
    }
}
