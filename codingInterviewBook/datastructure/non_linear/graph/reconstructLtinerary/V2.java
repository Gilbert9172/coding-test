package datastructure.non_linear.graph.reconstructLtinerary;

import java.util.*;

public class V2 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new LinkedList<>();
        HashMap<String, PriorityQueue<String>> route = new HashMap<>();

        for(List<String> ticket: tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            route.putIfAbsent(from, new PriorityQueue<>());
            route.get(from).add(to);
        }
        dfs(route, "JFK", result);
        return result;
    }

    void dfs(HashMap<String, PriorityQueue<String>> route, String from, List<String> result){
        PriorityQueue<String> arrivals = route.get(from);
        while(arrivals != null && !arrivals.isEmpty()){
            dfs(route, arrivals.poll(), result);
        }
        result.addFirst(from);
    }
}
