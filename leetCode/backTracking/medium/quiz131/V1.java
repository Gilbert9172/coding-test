package backTracking.medium.quiz131;

import java.util.ArrayList;
import java.util.List;

// 131. Palindrome Partitioning
public class V1 {

    private final List<List<String>> subsets = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0, new ArrayList<>());
        return subsets;
    }

    private void backTracking(
            String input,
            int cursor,
            List<String> subset
    ) {
        if (input.length() == cursor) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        for (int idx = cursor; idx < input.length(); idx++) {
            if (isPalindrome(input, cursor, idx)) {
                String substring = input.substring(cursor, idx + 1);
                subset.add(substring);
                backTracking(input, idx + 1, subset);
                subset.removeLast();
            }
        }
    }

    private boolean isPalindrome(String input, int start, int end) {
        while (start <= end) {
            char startChar = input.charAt(start);
            char endChar = input.charAt(end);
            start++;
            end--;
            if (startChar != endChar) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "aab";
        V1 v1 = new V1();
        List<List<String>> partitions = v1.partition(input);
        for (List<String> partition : partitions) {
            System.out.println(partition.toString());
        }
    }
}
