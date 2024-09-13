package level1;

import java.util.Arrays;

/**
 * 월간 코드 챌린지 시즌2
 * 음양 더하기
 */

public class quiz06 {

    public static void main(String[] args) {
        System.out.println(quiz06.Solution());
    }

    public static Integer Solution() {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        for (int i = 0; i < signs.length; i++) {
            if (signs[i] == false) {
                absolutes[i] = absolutes[i] * -1;
            }
        }
        int answer = Arrays.stream(absolutes).sum();
        return answer;
    }

}
