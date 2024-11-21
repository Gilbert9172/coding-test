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
            int idx,
            List<String> subset
    ) {
        if (input.length() == idx) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        for (int i = idx; i < input.length(); i++) {
            if (isPalindrome(input, idx, i)) {
                String substring = input.substring(idx, i + 1);
                subset.add(substring);
                backTracking(input, i + 1, subset);
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
        String input = "aaaab";
        V1 v1 = new V1();
        List<List<String>> partitions = v1.partition(input);
        for (List<String> partition : partitions) {
            System.out.println(partition.toString());
        }
    }
}
