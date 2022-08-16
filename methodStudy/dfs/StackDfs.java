package dfs;

import java.util.Stack;

/**
 * 재귀와 스텍 : https://bentist.tistory.com/57
 */

public class StackDfs {

    // 방문처리에 사용 할 배열선언
    static boolean[] visited = new boolean[9];

    // 그림예시 그래프의 연결상태를 2차원 배열로 표현
    // 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
    static int[][] graph = {{}, {2,3,8}, {1,7}, {1,4,5}, {3,5}, {3,4}, {7}, {2,6,8}, {1,7}};

    // DFS에 사용 할 스텍
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        // 1. 시작 노드를 스택에 넣어줍니다.
        stack.push(1);

        // 2. 시작 노드 방문처리
        visited[1] = true;

        // 3. 스택이 비어있지 않으면 계속 반복
        while (!stack.isEmpty()) {

            // 스택에서 하나씩 꺼낸다.
            int nodeIndex = stack.pop();

            // 방문 노드 출력
            System.out.println(nodeIndex + " -▶ ");

            // 꺼낸 노드에서 인접한 노드 찾기
            for (int linkedNode : graph[nodeIndex]) {
                if (!visited[linkedNode]) {
                    stack.push(linkedNode);
                    visited[linkedNode] = true;
                }
            }
        }
    }
}
