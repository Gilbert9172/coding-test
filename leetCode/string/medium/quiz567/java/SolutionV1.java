package string.medium.quiz567.java;

public class SolutionV1 {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        boolean answer = new SolutionV1().checkInclusion(s1, s2);
        System.out.println(answer);
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // s1 문자 빈도 저장
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++; // 초기 윈도우도 같이 저장
        }

        // 초기 윈도우 비교
        if (matches(s1Count, s2Count)) return true;

        // 슬라이딩 윈도우 이동
        for (int i = len1; i < len2; i++) {
            s2Count[s2.charAt(i) - 'a']++;                         // 오른쪽 문자 추가
            s2Count[s2.charAt(i - len1) - 'a']--;                  // 왼쪽 문자 제거

            if (matches(s1Count, s2Count)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
