package string.medium.quiz7;

public class SolutionV1 {

    public int reverse(int x) {
        var strInput = String.valueOf(Math.abs(x));
        var reveredCharArray = reversedChars(strInput.toCharArray());
        int reversedInt = fromCharArrToInt(reveredCharArray);
        if (reversedInt == -1) {
            return reversedInt;
        } else if (x < 0) {
            return reversedInt * -1;
        }
        return reversedInt;
    }

    private char[] reversedChars(char[] array) {
        int maxIdx = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            var temp = array[maxIdx - i];
            array[maxIdx - i] = array[i];
            array[i] = temp;
        }
        return array;
    }

    private int fromCharArrToInt(char[] array) {
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c);
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        int answer = solution.reverse(2147483647);
        System.out.println(answer);
    }
}
