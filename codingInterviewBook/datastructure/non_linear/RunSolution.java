package datastructure.non_linear;

import datastructure.non_linear.graph.CheapestFlightsWithinKStops;

public class RunSolution {
    public static void main(String[] args) {
        CheapestFlightsWithinKStops kStops = new CheapestFlightsWithinKStops();
        kStops.v2(3, new int[][]{{0,1,100}, {1,2,200},{0,2,500}}, 0, 2, 0);
    }
}
