package multiDemensionDP.medium.quiz5;

// Manacher 알고리즘
public class Manacher {
    public String longestPalindrome(String s) {
        // 1. 문자열 변환
        StringBuilder builder = new StringBuilder();
        builder.append("#");
        for (char c : s.toCharArray()) {
            builder.append(c).append("#");
        }
        String transformedInput = builder.toString();

        // 2. 변수 초기화
        int inputLen = transformedInput.length();
        int[] radiuses = new int[inputLen]; // 팰린드롬 반지름 배열
        int currentCenterIdx = 0, rightBoundary = 0; // 중심과 오른쪽 경계
        int maxLen = 0, centerIdxOfMaxPalindrome = 0;

        // 3. radiuses 배열 계산
        for (int i = 0; i < inputLen; i++) {
            int mirrorIdx = 2 * currentCenterIdx - i; // i의 거울 위치
            if (i < rightBoundary) {
                radiuses[i] = Math.min(rightBoundary - i, radiuses[mirrorIdx]);
            }

            // 4. 팰린드롬 확장
            while (i + radiuses[i] + 1 < inputLen && i - (radiuses[i] + 1) >= 0 &&
                    transformedInput.charAt(i + radiuses[i] + 1) == transformedInput.charAt(i - (radiuses[i] + 1))) {
                radiuses[i]++;
            }

            // 5. 중심과 오른쪽 경계 업데이트
            if (i + radiuses[i] > rightBoundary) {
                currentCenterIdx = i;
                rightBoundary = i + radiuses[i];
            }

            // 6. 최대 길이 갱신
            if (radiuses[i] > maxLen) {
                maxLen = radiuses[i];
                centerIdxOfMaxPalindrome = i;
            }
        }

        // 7. 결과 추출
        int start = (centerIdxOfMaxPalindrome - maxLen) / 2; // 원본 문자열에서 시작 위치
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String input = "xxx";
        Manacher solutionV2 = new Manacher();
        String answer = solutionV2.longestPalindrome(input);
        System.out.println(answer);
    }
}
