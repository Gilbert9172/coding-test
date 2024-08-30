package datastructure.non_linear.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> finishToTakeMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            finishToTakeMap.putIfAbsent(prerequisite[0], new ArrayList<>());
            finishToTakeMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        List<Integer> takes = new ArrayList<>();
        List<Integer> taken = new ArrayList<>();
        for (Integer finish : finishToTakeMap.keySet()) {
            if (!dfs(finishToTakeMap, finish, takes, taken)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> finishToTakeMap, Integer finish, List<Integer> takes, List<Integer> taken) {
        if (takes.contains(finish)) {
            return false;
        }
        if (taken.contains(finish)) {
            return true;
        }
        if (finishToTakeMap.containsKey(finish)) {
            takes.add(finish);
            for (Integer take : finishToTakeMap.get(finish)) {
                if (!dfs(finishToTakeMap, take, takes, taken)) {
                    return false;
                }
            }
            takes.remove(finish);
            taken.add(finish);
        }
        return true;
    }
}
