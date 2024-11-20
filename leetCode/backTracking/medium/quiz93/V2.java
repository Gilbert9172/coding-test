package backTracking.medium.quiz93;

import java.util.ArrayList;
import java.util.List;

// [LeetCode#93] Restore IP Addresses
public class V2 {

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> segments = new ArrayList<>();
        List<String> result = new ArrayList<>();

        restoreIpAddressHelper(s, n, segments, result, -1, 3);
        return result;
    }

    public boolean valid(String str) {
        if (str.length() > 3) {
            return false;
        }
        return (str.charAt(0) != '0') ? (Integer.parseInt(str) <= 255) : (str.length() == 1);
    }

    public void processLastSegment(String s, int n, List<String> segments, List<String> result, int currDot) {
        String segment = s.substring(currDot + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            String ip = String.join(".", segments);
            result.add(ip);
            segments.removeLast();
        }
    }

    public void restoreIpAddressHelper(String s, int n, List<String> segments, List<String> result, int previousDot, int dots) {
        int maxPos = Math.min(n - 1, previousDot + 4);
        for (int currDot = previousDot + 1; currDot < maxPos; currDot++) {
            String segment = s.substring(previousDot + 1, currDot + 1);
            if (valid(segment)) {
                segments.add(segment);
                if (dots - 1 == 0) {
                    processLastSegment(s, n, segments, result, currDot);
                } else {
                    restoreIpAddressHelper(s, n, segments, result, currDot, dots - 1);
                }
                segments.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        V2 v2 = new V2();
        String s = "25525511135";
        List<String> strings = v2.restoreIpAddresses(s);
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
