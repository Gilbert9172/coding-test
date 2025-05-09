package string.medium.quiz12;

public class SolutionV3 {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < values.length; i++) {
                if (num >= values[i]) {
                    result.append(roman[i]);
                    num -= values[i];
                    break;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SolutionV3 solution = new SolutionV3();
        String answer = solution.intToRoman(3146);
        System.out.println(answer);
    }
}
