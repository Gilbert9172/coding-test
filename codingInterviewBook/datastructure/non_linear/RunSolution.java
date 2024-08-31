package datastructure.non_linear;

import datastructure.non_linear.graph.courseSchedule.V1;

public class RunSolution {
    public static void main(String[] args) {
        V1 courseSchedule = new V1();
        int[][] prerequisites = {{1,0}, {2,1}};
        boolean answer = courseSchedule.canFinish(3, prerequisites);
        System.out.println(answer);
    }
}
