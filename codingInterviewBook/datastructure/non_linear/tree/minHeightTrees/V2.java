package datastructure.non_linear.tree.minHeightTrees;

import java.util.*;

public class V2 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 예외 처리
        if (n == 1) return List.of(0);

        // 트리 구조를 양방향 그래프로 구성
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new LinkedList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 리프 노드 추가
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 연결이 하나인 노드를 리프노드로 추가
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // 노드가 2개 이하로 남을 때 까지만 반복
        while (n > 2) {
            // 이전 단계 리프 노드 개수만큼 n에서 제거
            n -= leaves.size();
            // 단계별로 새롭게 리프노드 변수 선언
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                int neighbor = graph.get(leaf).getFirst();
                // 이웃 노드에서 리프 노드까지 연결 삭제
                graph.get(neighbor).remove(leaf);
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        // 2개 이하가 남은 최종 결과 리턴
        return leaves;
    }
}
