package dfs;


/**
 * DFS (깊이 우선 탐색)
 * 연결 된 노드를 따라서 계속 방문을 한 후에 더 이상 연결된 노드들이
 * 없을 때 그 전 노드로 되돌아가고 다시 연결된 노드를 따라서 탐색을 한다.
 * https://codingnojam.tistory.com/44
 */

public class RecursiveDfs {
    // 방문처리에 사용할 배열 선언
    static boolean[] visited = new boolean[9];

    // 그림예시 그래프의 연결 상태를 2차원 배열로 표현
    // 인덱스가 각각의 노드 번호가 될 수 있게 0번 인댁스는 아무것도 없는 상태라고 생각한다.
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    public static void main(String[] args) {
        dfs(1);
    }

    public static void dfs(int nodeIndex) {
        // 1. 방문 처리
        visited[nodeIndex] = true;

        // 2. 방문 노드 츨력력
        System.out.println("-▶ " + nodeIndex);

        // 3. 방문한 노드에 인접한 노드 찾기
        for (int node : graph[nodeIndex]) {

            // 4. 인접한 노드가 방문한 적이 없다면 DFS 수행
            if (firstVisit(node)) {
                dfs(node);
            }
        }
    }

    public static boolean firstVisit(int node) {
        if (!visited[node]) {
            return true;
        } else {
            return false;
        }
    }
}
