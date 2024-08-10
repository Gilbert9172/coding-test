package datastructure.linear.stakcQueue;

import java.util.PriorityQueue;

public class Spicier {

    public static int makeScoville(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.add(i);
        }

        int count = 1;
        while (pq.size() >= 2) {
            int firstMin = pq.poll();
            int secondMin = pq.poll();
            int newScoville = firstMin + (secondMin * 2);
            pq.add(newScoville);
            if (pq.peek() >= K) {
                return count;
            }
            count++;
        }
        return -1;
    }
}
