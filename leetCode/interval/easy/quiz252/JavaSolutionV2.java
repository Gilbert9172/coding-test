package interval.easy.quiz252;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JavaSolutionV2 {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(5, 8));
        intervals.add(new Interval(9, 15));

        boolean answer = new JavaSolutionV2().canAttendMeetings(intervals);
        System.out.println(answer);
    }

    private static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) return true;

        intervals.sort(Comparator.comparingInt(a -> a.start));

        int prevEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start < prevEnd) return false;
            prevEnd = current.end;
        }
        return true;
    }
}
