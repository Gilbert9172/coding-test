package levelTwo;

import java.util.*;

/**
 * 다리를 지나는 트럭
 */
public class quiz42583 {

    public static void main(String[] args) {

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        int max = 0;
        for (int truck_weight : truck_weights) {

            while (true) {
                if (q.isEmpty()) {
                    q.offer(truck_weight);
                    max += truck_weight;
                    answer++;
                    break;
                } else if (q.size() == bridge_length) {
                    max -= q.poll();
                } else {
                    if (max + truck_weight > weight) {
                        q.offer(0);
                        answer++;
                    } else {
                        q.offer(truck_weight);
                        max += truck_weight;
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer + bridge_length);
    }
}
