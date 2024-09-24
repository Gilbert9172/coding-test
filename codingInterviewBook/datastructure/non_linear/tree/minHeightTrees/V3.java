package datastructure.non_linear.tree.minHeightTrees;

import java.util.*;

public class V3 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Edge case: If there's only one node, return it as the ans
        if (n == 1) {
            return List.of(0);
        }
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        int[] deg = new int[n];
        // Create Adj List graph
        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
            deg[edge[0]]++;
            deg[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) {
                q.add(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            n -= size;
            for (int k = 0; k < size; k++) {
                int front = q.poll();
                for (int j : g.get(front)) {
                    deg[j]--;
                    // 이웃 노드의 차수가 1이라면 q에 삽입
                    if (deg[j] == 1) {
                        q.add(j);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }
}
