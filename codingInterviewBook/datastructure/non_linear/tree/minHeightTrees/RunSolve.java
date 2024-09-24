package datastructure.non_linear.tree.minHeightTrees;

import java.util.List;

public class RunSolve {
    public static void main(String[] args) {
//        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
//        int n = 6;

        int[][] edges = {{0,3},{1,3},{2,3},{4,3},{5,3},{6,5}};
        int n = 7;

//        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
//        int n = 6;

//        int[][] edges = {{}};
//        int n = 1;

        V3 solution = new V3();
        List<Integer> lowestHeightNode = solution.findMinHeightTrees(n, edges);
        for (Integer i : lowestHeightNode) {
            System.out.println(i);
        }
    }
}
