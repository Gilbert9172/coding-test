package levelOne;

import java.util.*;

/**
 * k번째 수
 */
public class quiz42748 {

    static int count = 0;

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = new int[commands.length];


        for (int[] command : commands) {

            int start = command[0] - 1; // 1
            int end = command[1] -1;   // 4
            int target = command[2] - 1;

            List<Integer> newArr = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                newArr.add(array[i]);
            }

            Collections.sort(newArr);

            answer[count] = newArr.get(target);
            count ++;
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
