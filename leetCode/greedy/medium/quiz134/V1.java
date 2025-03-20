package greedy.medium.quiz134;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * [134. Gas Station](https://leetcode.com/problems/gas-station/description/)
 */
public class V1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) {
            if (gas[0] >= cost[0]) {
                return 0;
            } else {
                return -1;
            }
        }
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] > 0) {
                pq.add(i);
            }
        }
        int answer = -1;
        while (!pq.isEmpty()) {
            boolean[] visited = new boolean[gas.length];
            int marker = pq.poll();
            int initial = marker;
            int remainGas = 0;
            while (!visited[marker]) {
                visited[marker] = true;
                remainGas += gas[marker] - cost[marker];
                // remain gas가 있다면 마커 한 칸 이동
                if (remainGas >= 0) {
                    if (marker >= gas.length - 1) {
                        marker = 0;
                    } else {
                        marker++;
                    }
                } else {
                    break;
                }
            }
            if (remainGas >= 0) {
                answer = initial;
                break;
            }
        }
        return answer;
    }
}
