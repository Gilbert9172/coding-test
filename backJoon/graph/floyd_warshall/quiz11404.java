package graph.floyd_warshall;

import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/11404">플로이드</a>
 */
public class quiz11404 {

    int n; // n개의 도시
    int m; //m개의 버스
    int[][] distance; // 최소비용
    int INF = 1000000000; //Integer.MAX_VALUE 로 하면 안된다. 나중에 더해줘야하는데 그럼 수가 초과해서 마이너스가된다. (주의)

    public void main(String[] args) {
        input();
        floyd();
        output();
    }

    private void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 인접행렬 만들기
        distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) distance[i][j] = 0;
                else distance[i][j] = INF;
            }
        }
        // 각 노드간의 최단 거리 인접행렬 update
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            distance[start][end] = Math.min(distance[start][end], weight);
        }
    }

    private void floyd() {

    }

    private void output() {
        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] >= INF) {
                    sb.append("0 ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
