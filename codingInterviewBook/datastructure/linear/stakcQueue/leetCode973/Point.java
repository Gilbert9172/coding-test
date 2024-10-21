package datastructure.linear.stakcQueue.leetCode973;

public class Point implements Comparable<Point> {

    private long distance;
    private int[] point;

    public Point(long distance, int[] point) {
        this.distance = distance;
        this.point = point;
    }

    public Point(int[] point) {
        this.distance = calculateDistanceUsing(point);
        this.point = point;
    }

    public long getDistance() {
        return distance;
    }

    public int[] getPoint() {
        return point;
    }

    private long calculateDistanceUsing(int[] point) {
        return (long) point[0] * point[0] + (long) point[1] * point[1];
    }

    @Override
    public int compareTo(Point other) {
        return Long.compare(this.getDistance(), other.getDistance());
    }
}
