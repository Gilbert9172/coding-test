package levelTwo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 주식 가격
 */
public class quiz42584 {

    static Integer index = 0;

    public static void main(String[] args) {


        int[] prices = {1, 2, 3, 2, 3, 1};
        int[] answer = new int[prices.length];

        // int[] -> List<Integer> -> Queue
        Queue<Integer> q = new LinkedList<>(Arrays.stream(prices).boxed().collect(Collectors.toList()));


        while (!q.isEmpty()) {

            Integer firstVal = q.poll();

            int count = 0;
            for (Integer nextVal : q) {
                if (nextVal >= firstVal){
                    count++;
                } else {
                    count ++;
                    break;
                }
            }
            answer[index] = count;
            index ++;
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
