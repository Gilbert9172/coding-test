package datastructure.non_linear.tree.minHeightTrees;

import java.util.*;

public class V1 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 결과 배열
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        // 최소 높이
        int lowest = Integer.MAX_VALUE;
        // edges 배열 to map
        Map<Integer, List<Integer> > graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new LinkedList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // main logic
        for (int i = 0; i < n; i++) {
            int height = depth(graph, i, -1);
            if (height < lowest) {
                lowest = height;
                result.clear();
                result.add(i);
            } else if (height == lowest) {
                result.add(i);
            }
        }

        return result;
    }

    private int depth(Map<Integer, List<Integer>> graph, int root, int prev) {
        int depth = -1;
        List<Integer> nextNodes = graph.get(root);
        for (Integer nextNode : nextNodes) {
            if (nextNode != prev) {
                depth = Math.max(depth, depth(graph, nextNode, root));
            }
        }
        depth++;
        return depth;
    }
}
