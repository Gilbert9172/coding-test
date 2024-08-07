package datastructure.linear.stakcQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 * 사용할 자료구조 = 우선순위 큐
 */
public class KClosestPointsToOrigin {

    public static class Point {
        long distance;
        int[] point;

        private Point(long distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }

    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> pointPQ = new PriorityQueue<>(pointComparator);

        for(int[] point : points) {
            pointPQ.add(new Point(calculateDistance(point), point));
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++) {
            if (pointPQ.isEmpty()) {
                return result;
            }
            Point target = pointPQ.poll();
            result[i] = target.point;
        }
        return result;
    }

    private Long calculateDistance(int[] point) {
        return ((long) point[0] * point[0]) + ((long) point[1] * point[1]);
    }

    public Comparator<Point> pointComparator = new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {
            if (p1.distance == p2.distance) {
                return 0;
            } else if (p1.distance > p2.distance) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
