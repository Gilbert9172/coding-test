package datastructure.linear.stakcQueue.leetCode973;

import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 * 사용할 자료구조 = 우선순위 큐
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pointPQ = new PriorityQueue<>();
        for (int[] point : points) {
            pointPQ.add(new Point(point));
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            if (pointPQ.isEmpty()) {
                return result;
            }
            Point target = pointPQ.poll();
            result[i] = target.getPoint();
        }
        return result;
    }
}
