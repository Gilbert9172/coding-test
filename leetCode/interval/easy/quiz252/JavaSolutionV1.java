package interval.easy.quiz252;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class JavaSolutionV1 {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(5, 8));
        intervals.add(new Interval(9, 15));

        boolean answer = new JavaSolutionV1().canAttendMeetings(intervals);
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

        Interval base = intervals.getFirst();

        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= base.end) {
                return false;
            } else {
                base.start = interval.start;
                base.end = interval.end;
            }
        }
        return true;
    }
}
