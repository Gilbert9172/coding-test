package datastructure.non_linear;

import datastructure.non_linear.graph.TravelRoute;

public class RunSolution {
    public static void main(String[] args) {
        TravelRoute travelRoute = new TravelRoute();
        String[][] tickets = {{"ICN", "A"}, {"ICN", "B"}, {"B", "C"}, {"A", "C"}};
        travelRoute.solution(tickets);
    }
}
