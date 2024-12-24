package string.medium.quiz12;

import java.util.HashMap;
import java.util.Map;

public class SolutionV1 {

    private final Map<Integer, String> normalForm = new HashMap<>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");
    }};

    private final Map<Integer, String> substractedForm = new HashMap<>() {{
        put(4, "IV");
        put(9, "IX");
        put(40, "XL");
        put(90, "XC");
        put(400, "CD");
        put(900, "CM");
    }};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            String source = String.valueOf(num);

            if (source.charAt(0) == '4' || source.charAt(0) == '9') {
                int maxValueFromSubsForm = getMaxValueFrom(num, substractedForm);
                sb.append(substractedForm.get(maxValueFromSubsForm));
                num -= maxValueFromSubsForm;
            } else {
                int maxValueFromNormalForm = getMaxValueFrom(num, normalForm);
                sb.append(normalForm.get(maxValueFromNormalForm));
                num -= maxValueFromNormalForm;
            }
        }

        return sb.toString();
    }

    public int getMaxValueFrom(int source, Map<Integer, String> form) {
        int value = 0;
        for (Integer key : form.keySet()) {
            if (key <= source) {
                value = Math.max(value, key);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        String answer = solution.intToRoman(1);
        System.out.println(answer);
    }
}
