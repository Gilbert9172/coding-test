package datastructure.non_linear.graph.reconstructLtinerary;

import java.util.*;

public class V1 {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> route = new HashMap<>();
        for (List<String> ticket : tickets) {
            route.putIfAbsent(ticket.getFirst(), new PriorityQueue<>());
            route.get(ticket.getFirst()).add(ticket.getLast());
        }

        List<String> results = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (route.containsKey(stack.getFirst()) && !route.get(stack.getFirst()).isEmpty()) {
                stack.push(route.get(stack.getFirst()).poll());
            }
            results.addFirst(stack.pop());
        }
        return results;
    }
}
