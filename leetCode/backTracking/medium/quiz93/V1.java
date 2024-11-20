package backTracking.medium.quiz93;

import java.util.ArrayList;
import java.util.List;

// [LeetCode#93] Restore IP Addresses
public class V1 {

    List<String> answer = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTracking("", 0, 0, s);
        return answer;
    }

    private void backTracking(
            String path,
            int idx,
            int dotCount,
            String s
    ) {
        // Invalid Condition
        if (dotCount > 4) return;

        // Valid Condition
        if (dotCount == 4 && idx >= s.length()) {
            answer.add(path.substring(0, path.length() - 1));
            return;
        }

        // 길이는 1~3 && idx가 문자열 내 위치
        for (int length = 1; length <= 3 && idx + length <= s.length(); length++) {
            String num = s.substring(idx, idx + length);
            if (num.charAt(0) == '0' && length != 1) break;
            else if (Integer.parseInt(num) <= 255) {
                // idx + length : 1, 11, 111 이런 식으로 문자열을 추가하기 위함
                backTracking(path + num + ".", idx + length, dotCount + 1, s);
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        V1 v1 = new V1();
        List<String> answers = v1.restoreIpAddresses(s);
        for (String answer : answers) {
            System.out.println(answer);
        }
    }
}
