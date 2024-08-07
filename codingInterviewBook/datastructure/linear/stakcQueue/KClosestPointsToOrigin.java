package datastructure.linear.stakcQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 * 사용할 자료구조 = 우선순위 큐
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> distanceComparator = (p1, p2) -> getDistance(p1).compareTo(getDistance(p2));
        PriorityQueue<int[]> pq = new PriorityQueue<>(distanceComparator);

        for(int[] point : points) {
            pq.add(point);
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    private Long getDistance(int[] point) {
        return ((long) point[0] * point[0]) + ((long) point[1] * point[1]);
    }
}
