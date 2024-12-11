package string.medium.quiz6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        List<List<Character>> bucket = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            bucket.add(new ArrayList<>());
        }

        int idx = 0;
        int dir = 1;
        for (char c : s.toCharArray()) {
            bucket.get(idx).add(c);
            if (idx == 0) {
                dir = 1;
            } else if (idx == numRows - 1) {
                dir = -1;
            }
            idx += dir;
        }

        return bucket.stream()
                .flatMap(Collection::stream)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "PAYPALISHIRING";
        String answer = solution.convert(input, 4);
        System.out.println(answer);
    }
}
