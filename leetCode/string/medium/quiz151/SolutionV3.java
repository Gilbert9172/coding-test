package string.medium.quiz151;

public class SolutionV3 {

    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");

        StringBuilder out = new StringBuilder();
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out.append(str[i]).append(" ");
        }

        return out + str[0];
    }

    public static void main(String[] args) {
        String s = "  the  sky  is    blue  ";

        SolutionV3 solution = new SolutionV3();
        String answer = solution.reverseWords(s);
        System.out.println(answer);
    }

}
