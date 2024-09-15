package datastructure.non_linear.graph.networkDelayTime;

public class RunSolution {
    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;

        solution.v3(times, n, k);
    }
}
