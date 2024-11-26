package backTracking.medium.quiz1849;

import java.util.ArrayList;
import java.util.List;

public class V1 {

    public boolean splitString(String s) {
        List<Long> bucket = new ArrayList<>();
        return backTracking(s.toCharArray(), 0, bucket);
    }

    private boolean backTracking(
            char[] digits,
            int cursor,
            List<Long> bucket
    ) {
        if (cursor >= digits.length && bucket.size() > 1) {
            return true;
        }

        for (int idx = cursor; idx < digits.length; idx++) {
            long subDigit = subDigit(digits, cursor, idx + 1);
            if (bucket.isEmpty() || (bucket.getLast() - subDigit == 1)) {
                bucket.add(subDigit);
                if (backTracking(digits, idx + 1, bucket)) return true;
                bucket.removeLast();
            }
        }
        return false;
    }

    private long subDigit(char[] digits, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + digits[i] - '0';
        }
        return res;
    }

    public static void main(String[] args) {
        V1 v1 = new V1();
        boolean result = v1.splitString("99989796959493929190898887");
        System.out.println(result);
    }
}
