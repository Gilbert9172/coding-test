package greedy.taskScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class V1 {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for (char c : tasks) {
            freqs[c - 'A']++;
        }
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int freq : freqs) {
            if (freq > 0) {
                pq.add(freq);
            }
        }

        int result = 0;
        while (true) {
            int intervals = 0;
            List<Integer> pendingTasks = new ArrayList<>();
            while (!pq.isEmpty()) {
                int frequency = pq.poll();
                if (intervals < n + 1) {
                    intervals ++;
                    result ++;
                    if (frequency > 1) {
                        pendingTasks.add(frequency - 1);
                    }
                } else {
                    pendingTasks.add(frequency);
                }
            }
            if (pendingTasks.isEmpty()) {
                break;
            }
            pq.addAll(pendingTasks);
            result += n + 1 - intervals;
        }
        return result;
    }
}
