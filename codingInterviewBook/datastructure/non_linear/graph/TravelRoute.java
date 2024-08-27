package datastructure.non_linear.graph;

import java.util.*;

// 프로그래머스 : 여행 경로
public class TravelRoute {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> route = new HashMap<>();
        for(String[] ticket: tickets){
            String from = ticket[0];
            String to = ticket[1];
            route.putIfAbsent(from, new PriorityQueue<>());
            route.get(from).add(to);
        }


        List<String> answer = new LinkedList<>();
        dfs(route, answer, "ICN");
        return answer.toArray(String[]::new);
    }

    private void dfs(Map<String, PriorityQueue<String>> route, List<String> answer, String from) {
        PriorityQueue<String> arrivals = route.get(from);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(route, answer, arrivals.poll());
        }
        answer.addFirst(from);
    }
}
