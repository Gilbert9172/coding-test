package algorithm.sort.largestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class V1 {


    public static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if (a.length() == b.length()) {
                return b.compareTo(a);
            } else {
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab);
            }
        }
    }
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) numsStr[i] = String.valueOf(nums[i]);
        Arrays.sort(numsStr, new StringComparator());
        return numsStr[0].equals("0") ? "0" : convertToString(numsStr);
    }

    private String convertToString(String[] strArr) {
        StringBuilder result = new StringBuilder();
        for (String num : strArr) {
            result.append(num);
        }
        return result.toString();
    }
}
