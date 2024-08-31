package datastructure.non_linear.graph.courseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class V2 {

    public boolean courseSchedule(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }

        int[] inDegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegrees[prerequisites[i][0]] ++;
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int val : courses.get(node)) {
                inDegrees[val]--;
                if (inDegrees[val] == 0) {
                    q.add(val);
                }
            }
        }
        return count == numCourses;
    }
}
