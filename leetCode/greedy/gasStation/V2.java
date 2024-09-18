package greedy.gasStation;

import java.util.Arrays;

public class V2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int sum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            if (sum + gas[i] < cost[i]) {
                start = i + 1;
                sum = 0;
            } else {
                sum += gas[i] - cost[i];
            }
        }
        return start;
    }
}
