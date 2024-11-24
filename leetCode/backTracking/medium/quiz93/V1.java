package backTracking.medium.quiz93;

import java.util.ArrayList;
import java.util.List;

// [LeetCode#93] Restore IP Addresses
public class V1 {

    List<String> answer = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0, 0, new StringBuilder());
        return answer;
    }

    private void backTracking(
            String s,
            int dotCount,
            int cursor,
            StringBuilder ip
    ) {
        if (dotCount > 4) {
            return;
        }
        if (dotCount == 4 && cursor >= s.length()) {
            answer.add(ip.substring(0, ip.length() - 1));
            return;
        }

        for (int length = 1; length <= 3 && cursor + length <= s.length(); length++) {
            String segment = s.substring(cursor, cursor + length);
            if (segment.charAt(0) == '0' && segment.length() != 1) {
                break;
            }
            if (Integer.parseInt(segment) <= 255) {
                int prevLength = ip.length();
                ip.append(segment).append(".");
                backTracking(s, dotCount + 1, cursor + length, ip);
                ip.setLength(prevLength);
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
