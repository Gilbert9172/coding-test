package levelOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.*;

/**
 * k번째 수
 */
public class quiz42748 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(Solution.solution(array, commands)));
    }

    static class Solution {
        static int[] solution(int[] array, int[][] commands) {

            List<Integer> targetLst = new ArrayList<>();

            for (int[] command : commands) {

                int start = command[0] - 1;
                int end = command[1];
                int targetIdx = command[2];

                int[] ints = copyOfRange(array, start, end);
                sort(ints);
                targetLst.add(ints[targetIdx - 1]);
            }

            return targetLst.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
