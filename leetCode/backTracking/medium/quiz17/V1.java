package backTracking.medium.quiz17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class V1 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        Map<Character, String> characterMap = initiateMap();
        StringBuilder currentCombination = new StringBuilder();
        backTracking(digits, 0, characterMap, currentCombination, result);
        return result;
    }

    private void backTracking(
            String digits,
            int idx,
            Map<Character, String> characterMap,
            StringBuilder builder,
            List<String> result
    ) {
        if (idx == digits.length()) {
            result.add(builder.toString());
            return;
        }
        char digit = digits.charAt(idx);
        String letters = characterMap.get(digit);
        for (char letter : letters.toCharArray()) {
            builder.append(letter);
            backTracking(digits, idx + 1, characterMap, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private Map<Character, String> initiateMap() {
        return Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );
    }

    public static void main(String[] args) {
        V1 v1 = new V1();
        List<String> answer = v1.letterCombinations("23");
        answer.forEach(System.out::println);
    }
}
