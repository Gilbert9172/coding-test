package datastructure.non_linear;

import datastructure.non_linear.graph.CourseSchedule;
import datastructure.non_linear.graph.TravelRoute;

public class RunSolution {
    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = {{1,0}, {2,1}};
        boolean answer = courseSchedule.canFinish(3, prerequisites);
        System.out.println(answer);
    }
}
