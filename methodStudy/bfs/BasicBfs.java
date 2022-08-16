package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 너비 우선 탐색이라고 부르기도 하며, 코딩 테스에에서 자주 등장하는 알고리즘 중에 하나이다.
 * 기본적으로 그래프 탐색에 사용되며, 가까운 노드부터 우선적으로 탐색하는 알고리즘입니다.
 * BFS는 Queue 자료구조를 사용해서 구현할 수 있습니다.
 * 사실 BFS 구현자체는 어렵지 않다.
 * 그러나 실제 코딩 테스트 문제를 풀어보면 단순히 구현하는 것보다 구현 과정에서
 * 문제를 해결을 위해 코드가 추가되거나 응용해서 생각해야 하는 부분들이 있다.
 */

 public class BasicBfs {

    public static void main(String[] args) {
        int[][] graph = {{}, {2,3,8}, {1,7}, {1,4,5}, {3,5}, {3,4}, {7}, {2,6,8}, {1,7}};

        // 방문 처리를 위한 boolean배열 선언
        boolean[] visited = new boolean[9];

        System.out.println(bfs(1, graph, visited));
    }

    static String bfs(int start, int[][] graph, boolean[] visited) {
        // 탐색 순서를 출력하기 위한 용도
        StringBuilder sb = new StringBuilder();

        // BFS에 사용할 큐 생성
        Queue<Integer> q = new LinkedList<>();

        // 1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
        q.offer(start);

        // 시작노드 방문처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int nodeIndex = q.poll();
            sb.append(" -> " + nodeIndex);

            // 큐에서 꺼낸 노드와 연결된 노드들 체크
            for (int i = 0; i < graph[nodeIndex].length; i++) {
                int temp = graph[nodeIndex][i];
                // 방문하지 않았다면
                if (!visited[temp]) {
                    q.offer(temp);
                    visited[temp] = true;
                }
            }
        }
        return sb.toString();
    }
}
